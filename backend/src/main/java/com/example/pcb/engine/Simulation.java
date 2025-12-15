package com.example.pcb.engine;

import com.example.pcb.engine.outcome.AttemptResult;
import com.example.pcb.engine.pcb.PCB;
import com.example.pcb.engine.pcb.PcbFactory;
import com.example.pcb.engine.station.AssemblyStation;
import com.example.pcb.engine.station.StationFactory;
import com.example.pcb.model.SimulationResult;
import com.example.pcb.repository.entity.PcbType;
import com.example.pcb.repository.entity.FailureRate;
import com.example.pcb.service.FailureRateService;

import java.util.*;

// Orchestrates the entire simulation flow of initializing stations, looping through the desired number of PCBs, 
// and building the results

public class Simulation {

    private final PcbType pcbType;
    private final List<FailureRate> failureRates;
    private final FailureRateService failureRateService;

    private final List<AssemblyStation> stations = new ArrayList<>();

    private int successCount;
    private int failureCount;

    private final Map<String, Integer> stationFailureCounts = new HashMap<>();
    private final Map<String, Integer> pcbDefectFailureCounts = new HashMap<>();

    public Simulation(PcbType pcbType, List<FailureRate> failureRates, FailureRateService failureRateService) {
        this.pcbType = pcbType;
        this.failureRates = failureRates;
        this.failureRateService = failureRateService;
    }

    public SimulationResult run(int count) {
        resetState();
        initializeStations();

        for (int i = 0; i < count; i++) {
            simulateSinglePcb();
        }

        return buildResult(count);
    }

    private void simulateSinglePcb() {
        // Create a PCB using the factory
        PCB pcb = PcbFactory.create(pcbType, failureRates);

        AssemblyAttempt attempt = new AssemblyAttempt(stations);
        AttemptResult result = attempt.assemble(pcb);

        if (result.success()) {
            successCount++;
            return;
        }

        failureCount++;

        String station = result.failureStation().getClass().getSimpleName();

        if (result.stationFailure()) {
            stationFailureCounts.merge(station, 1, Integer::sum);
        } else {
            pcbDefectFailureCounts.merge(station, 1, Integer::sum);
        }
    }

    // Use the factory to build all the stations instead of instantiating them directly

    private void initializeStations() {
        stations.addAll(StationFactory.createDefaultStations(failureRateService));
    }

    // Reset state to avoid duplicating results

    private void resetState() {
        successCount = 0;
        failureCount = 0;

        stations.clear();
        stationFailureCounts.clear();
        pcbDefectFailureCounts.clear();
    }

    // Build SimulationResult from the simulation output

    private SimulationResult buildResult(int count) {
        return new SimulationResult(
                pcbType.getName(),
                count,
                successCount,
                failureCount,
                stationFailureCounts,
                pcbDefectFailureCounts
        );
    }
}
