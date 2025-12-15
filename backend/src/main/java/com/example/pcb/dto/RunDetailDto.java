package com.example.pcb.dto;

import java.util.List;

public class RunDetailDto {
    public long runId;
    public String boardType;

    public int pcbsRun;
    public int totalSuccesses;
    public int totalFailures;

    public List<FailureCountDto> stationFailures;
    public List<FailureCountDto> pcbDefectFailures;

    public RunDetailDto(long runId, String boardType, int pcbsRun, int totalSuccesses, int totalFailures,
                        List<FailureCountDto> stationFailures, List<FailureCountDto> pcbDefectFailures) {
        this.runId = runId;
        this.boardType = boardType;
        this.pcbsRun = pcbsRun;
        this.totalSuccesses = totalSuccesses;
        this.totalFailures = totalFailures;
        this.stationFailures = stationFailures;
        this.pcbDefectFailures = pcbDefectFailures;
    }
}
