package com.example.pcb.service;

import com.example.pcb.dto.*;
import com.example.pcb.repository.SimulationRunRepository;
import com.example.pcb.repository.FailureRateRepository;
import com.example.pcb.repository.entity.SimulationRun;
import com.example.pcb.repository.entity.FailureRate;
import com.example.pcb.repository.entity.PcbType;
import com.example.pcb.repository.PcbTypeRepository;
import com.example.pcb.engine.SimulationEngine;
import com.example.pcb.model.SimulationResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// Simulation service that is called by the controller, handling running the simulation,
// saving results to the DB, and returning data in the requested format

@Service
public class SimulationService {

    private final SimulationEngine engine;
    private final SimulationRunRepository repo;
    private final FailureRateRepository failureRateRepo;
    private final PcbTypeRepository pcbTypeRepository;
    private final ObjectMapper mapper = new ObjectMapper();

    public SimulationService(SimulationEngine engine,
                             SimulationRunRepository repo,
                             FailureRateRepository failureRateRepo,
                             PcbTypeRepository pcbTypeRepository) {
        this.engine = engine;
        this.repo = repo;
        this.failureRateRepo = failureRateRepo;
        this.pcbTypeRepository = pcbTypeRepository;
    }

    // Run simulation using lookups of PCB type and failure rates, and using the simulation engine
    public RunDetailDto runSimulation(RunRequestDto req) {

        PcbType type = pcbTypeRepository.findByName(req.boardType)
                .orElseThrow(() -> new RuntimeException("Unknown board type: " + req.boardType));

        List<FailureRate> rates = failureRateRepo.findByPcbTypeName(req.boardType);

        SimulationResult result = engine.runSimulation(type, rates, req.count);

        try {
            // Save run to DB
            String json = mapper.writeValueAsString(result);
            SimulationRun saved = repo.save(new SimulationRun(json));

            return mapToRunDetailDto(saved.getId(), result);

        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize simulation result", e);
        }
    }

    // List all runs
    public List<SimulationRunSummaryDto> listRuns() {
        return repo.findAll().stream()
                .map(run -> {
                    try {
                        SimulationResult result =
                                mapper.readValue(run.getResultJson(), SimulationResult.class);

                        return new SimulationRunSummaryDto(
                                run.getId(),
                                result.getBoardType(),
                                result.getPcbsRun()
                        );

                    } catch (Exception e) {
                        throw new RuntimeException("Failed parsing run JSON", e);
                    }
                })
                .collect(Collectors.toList());
    }

    // Get results of one run
    public RunDetailDto getRun(Long id) {
        SimulationRun run = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Run not found"));

        try {
            SimulationResult result =
                    mapper.readValue(run.getResultJson(), SimulationResult.class);

            return mapToRunDetailDto(run.getId(), result);

        } catch (Exception e) {
            throw new RuntimeException("Failed parsing run JSON", e);
        }
    }

    // Convert SimulationResult to RunDetailDto
    private RunDetailDto mapToRunDetailDto(Long id, SimulationResult result) {

        List<FailureCountDto> stationFailures =
                result.getStationFailures().entrySet().stream()
                        .map(e -> new FailureCountDto(e.getKey(), e.getValue()))
                        .collect(Collectors.toList());

        List<FailureCountDto> pcbDefectFailures =
                result.getPcbDefectFailures().entrySet().stream()
                        .map(e -> new FailureCountDto(e.getKey(), e.getValue()))
                        .collect(Collectors.toList());

        return new RunDetailDto(
                id,
                result.getBoardType(),
                result.getPcbsRun(),
                result.getTotalSuccesses(),
                result.getTotalFailures(),
                stationFailures,
                pcbDefectFailures
        );
    }
}
