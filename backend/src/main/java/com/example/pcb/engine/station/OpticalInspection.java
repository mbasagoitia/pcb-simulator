package com.example.pcb.engine.station;

import com.example.pcb.engine.outcome.Outcome;
import com.example.pcb.engine.outcome.Success;
import com.example.pcb.engine.outcome.PCBDefectFailure;
import com.example.pcb.engine.outcome.StationFailure;

import com.example.pcb.engine.pcb.GatewayBoard;
import com.example.pcb.engine.pcb.PCB;
import com.example.pcb.engine.pcb.SensorBoard;
import com.example.pcb.engine.pcb.TestBoard;

import com.example.pcb.service.FailureRateService;

import org.springframework.beans.factory.annotation.Autowired;

public class OpticalInspection extends AssemblyStation implements PCBCheckStation {

    private final FailureRateService failureRateService;

    public OpticalInspection(FailureRateService failureRateService) {
        this.failureRateService = failureRateService;
    }

    @Override
    public Outcome performAssembleStep() {
        double rate = failureRateService.getFailureRate(
            currentPCB.getName(),
            this.getName()
        );

        if (!checkForStationFailure()) {
            if (!checkForPCBDefects(rate)) {
                return new Success(this, currentPCB);
            }
            return new PCBDefectFailure(this, currentPCB);
        }
        return new StationFailure(this, currentPCB);
    }

    @Override    
    public String getName() {
        return "OpticalInspection";
    }
}
