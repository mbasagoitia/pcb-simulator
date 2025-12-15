package com.example.pcb.engine.station;

import com.example.pcb.engine.outcome.Outcome;

public abstract class AssemblyStation extends Station {
    protected static final double STATION_FAILURE_RATE = 0.002;

    public boolean checkForStationFailure() {
        if (Math.random() < STATION_FAILURE_RATE) {
            return true;
        }
        return false;
    }

    public abstract Outcome performAssembleStep();

}
