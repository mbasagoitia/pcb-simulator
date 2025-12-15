package com.example.pcb.engine.outcome;

import com.example.pcb.engine.station.Station;
import com.example.pcb.engine.pcb.PCB;

public class Success extends Outcome {
        public Success(Station station, PCB currentPCB) {
        super(station, currentPCB);
    }
    public void handleOutcome() {
        // System.out.println(station.getName() + " successfully performed on " + pcb.getName());
    };
}
