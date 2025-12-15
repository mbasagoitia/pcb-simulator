package com.example.pcb.engine.station;

import com.example.pcb.engine.pcb.PCB;

public abstract class Station {
    protected PCB currentPCB;

    public void setCurrentPCB(PCB pcb) {
        this.currentPCB = pcb;
    }

    public abstract String getName();
}
