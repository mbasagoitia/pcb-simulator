package com.example.pcb.engine.outcome;

import com.example.pcb.engine.station.Station;
import com.example.pcb.engine.pcb.PCB;

public abstract class Failure extends Outcome {
    public Failure(Station station, PCB currentPcb) {
        super(station, currentPcb);
    }

    public abstract void handleOutcome();
}
