package com.example.pcb.engine.outcome;

import com.example.pcb.engine.station.Station;
import com.example.pcb.engine.pcb.PCB;

public class StationFailure extends Failure {
    public StationFailure(Station station, PCB currentPCB) {
        super(station, currentPCB);
    }
    public void handleOutcome() {
        // System.out.println(station.getName() + " experienced a station failure");
    };
}
