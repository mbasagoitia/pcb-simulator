package com.example.pcb.engine.pcb;

import com.example.pcb.repository.entity.FailureRate;

import java.util.List;

public class SensorBoard extends PCB {

    private final String typeName;
    private final List<FailureRate> failureRates;

    public SensorBoard(String typeName, List<FailureRate> failureRates) {
        this.typeName = typeName;
        this.failureRates = failureRates;
    }

    @Override
    public String getName() {
        return typeName;
    }

    public List<FailureRate> getFailureRates() {
        return failureRates;
    }
}
