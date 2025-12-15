package com.example.pcb.engine;

import com.example.pcb.repository.entity.PcbType;
import com.example.pcb.model.SimulationResult;
import com.example.pcb.repository.entity.FailureRate;
import com.example.pcb.service.FailureRateService;
import org.springframework.stereotype.Component;

import java.util.List;

// Wrapper class that initializes simulation and calls its run method

@Component
public class SimulationEngine {

    private final FailureRateService failureRateService;

    public SimulationEngine(FailureRateService failureRateService) {
        this.failureRateService = failureRateService;
    }

    // Facade pattern hides the complexity of the run simulation logic behind a simple interface--
    // clearing state, initializing stations, looping through desired number of PBCs,
    // and building result (see Simulation)

    public SimulationResult runSimulation(PcbType pcbType, List<FailureRate> failureRates, int count) {
        Simulation simulation = new Simulation(pcbType, failureRates, failureRateService);
        return simulation.run(count);
    }
}
