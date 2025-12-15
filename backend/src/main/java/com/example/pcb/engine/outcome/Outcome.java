package com.example.pcb.engine.outcome;

import com.example.pcb.engine.station.Station;
import com.example.pcb.engine.pcb.PCB;

public abstract class Outcome {
    protected PCB pcb;
    protected Station station;

    public Outcome(Station station, PCB currentPCB) {
        this.station = station;
        this.pcb = currentPCB;
    };

    public Station getStation() {
        return station;
    }

    public abstract void handleOutcome();
}
