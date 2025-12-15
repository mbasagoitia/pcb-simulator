package com.example.pcb.engine.outcome;

import com.example.pcb.engine.station.Station;
import com.example.pcb.engine.pcb.PCB;

public class PCBDefectFailure extends Failure {
        public PCBDefectFailure(Station station, PCB currentPCB) {
        super(station, currentPCB);
    }
    public void handleOutcome() {
        // System.out.println(station.getName() + " detected a defect on " + pcb.getName());
    };
}
