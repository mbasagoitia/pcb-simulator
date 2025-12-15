package com.example.pcb.engine.station;

import com.example.pcb.engine.outcome.Outcome;
import com.example.pcb.engine.outcome.Success;
import com.example.pcb.engine.outcome.StationFailure;

public class Depanelization extends AssemblyStation {
    
    public Outcome performAssembleStep () {
        if (!checkForStationFailure()) {
            return new Success(this, currentPCB);
        }
        return new StationFailure(this, currentPCB);
    }

    public String getName() {
        return "Depanelization";
    }
}
