package com.example.pcb.engine;

import java.util.List;

import com.example.pcb.engine.station.AssemblyStation;
import com.example.pcb.engine.pcb.PCB;
import com.example.pcb.engine.outcome.Outcome;
import com.example.pcb.engine.outcome.StationFailure;
import com.example.pcb.engine.outcome.Failure;
import com.example.pcb.engine.outcome.AttemptResult;

// Represents the result of one simulated PCB
// This is later aggregated into a SimulationResult with all AssemblyAttempts

public class AssemblyAttempt {
    private final List<AssemblyStation> stations;

    public AssemblyAttempt(List<AssemblyStation> stations) {
        this.stations = stations;
    }

    public AttemptResult assemble(PCB pcb) {
        for (AssemblyStation station : stations) {
            station.setCurrentPCB(pcb);

            Outcome outcome = station.performAssembleStep();
            outcome.handleOutcome();

            if (outcome instanceof Failure) {
                removePCB(pcb);
                if (outcome instanceof StationFailure) {
                    return new AttemptResult(false, true, outcome.getStation());
                }
                else {
                    return new AttemptResult(false, false, outcome.getStation());
                }
            }
        }
        return new AttemptResult(true, false, null);
    }

    private void removePCB(PCB pcb) {
        // System.out.println("Removing PCB " + pcb.getName() + " from line.");
    }
}
