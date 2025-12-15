package com.example.pcb.engine.pcb;

public abstract class PCB {
    protected static int id;
    public PCB() {
        id++;
    }

    public abstract String getName();
}
