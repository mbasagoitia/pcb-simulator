package com.example.pcb.engine.pcb;

import com.example.pcb.repository.entity.PcbType;
import com.example.pcb.repository.entity.FailureRate;

import java.util.List;

// Factory to create a given PCB type; matches front end POST request format

public class PcbFactory {

    public static PCB create(PcbType type, List<FailureRate> rates) {
        String name = type.getName().toLowerCase();


        return switch (name) {
            case "gatewayboard"      -> new GatewayBoard(type.getName(), rates);
            case "testboard"    -> new TestBoard(type.getName(), rates);
            case "sensorboard"       -> new SensorBoard(type.getName(), rates);

            default -> throw new IllegalArgumentException(
                    "Unsupported PCB type: " + type.getName()
            );
        };
    }
}
