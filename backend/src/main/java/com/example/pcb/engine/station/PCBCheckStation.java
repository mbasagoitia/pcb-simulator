package com.example.pcb.engine.station;

// Implemented only by the assembly stations that check for PCB defects

public interface PCBCheckStation {
    default boolean checkForPCBDefects(double PCBDefectRate) {
        if (Math.random() < PCBDefectRate) {
            return true;
        }
        return false;
    }
}
