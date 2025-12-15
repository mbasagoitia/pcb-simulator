package com.example.pcb.controller;

import com.example.pcb.dto.RunRequestDto;
import com.example.pcb.dto.RunDetailDto;
import com.example.pcb.dto.SimulationRunSummaryDto;
import com.example.pcb.service.SimulationService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RestController
@RequestMapping("/simulation")
@CrossOrigin

// Controller api that maps frontend requests to service calls

public class SimulationController {

    private final SimulationService service;

    public SimulationController(SimulationService service) {
        this.service = service;
    }

    @PostMapping("/run")
    public RunDetailDto runSimulation(@RequestBody RunRequestDto req) {
        return service.runSimulation(req);
    }

    @GetMapping("/runs")
    public List<SimulationRunSummaryDto> listRuns() {
        return service.listRuns();
    }

    @GetMapping("/runs/{id}")
    public RunDetailDto getRun(@PathVariable Long id) {
        return service.getRun(id);
    }
}
