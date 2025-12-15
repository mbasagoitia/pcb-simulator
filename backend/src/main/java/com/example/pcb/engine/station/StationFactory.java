package com.example.pcb.engine.station;

import com.example.pcb.service.FailureRateService;
import java.util.ArrayList;
import java.util.List;

// Station creation abstracted into a StationFactory

public class StationFactory {

    public static List<AssemblyStation> createDefaultStations(FailureRateService failureRateService) {
        List<AssemblyStation> stations = new ArrayList<>();

        stations.add(new ApplySolderPaste());
        stations.add(new PlaceComponents(failureRateService));  
        stations.add(new ReflowSolder()); 
        stations.add(new OpticalInspection(failureRateService)); 
        stations.add(new HandSolderAssembly(failureRateService));
        stations.add(new Cleaning());
        stations.add(new Depanelization());
        stations.add(new TestICTFlyingProbe(failureRateService));

        return stations;
    }
}
