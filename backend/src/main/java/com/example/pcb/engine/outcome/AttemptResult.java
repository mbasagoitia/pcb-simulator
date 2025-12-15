package com.example.pcb.engine.outcome;

import com.example.pcb.engine.station.Station;

public record AttemptResult(boolean success, boolean stationFailure, Station failureStation) {}
