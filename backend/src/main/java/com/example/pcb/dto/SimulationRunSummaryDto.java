package com.example.pcb.dto;

public class SimulationRunSummaryDto {

    private long runId;
    private String boardType;
    private int pcbsRun;

    public SimulationRunSummaryDto() {}

    public SimulationRunSummaryDto(long runId, String boardType, int pcbsRun) {
        this.runId = runId;
        this.boardType = boardType;
        this.pcbsRun = pcbsRun;
    }

    public long getRunId() {
        return runId;
    }

    public void setRunId(long runId) {
        this.runId = runId;
    }

    public String getBoardType() {
        return boardType;
    }

    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }

    public int getPcbsRun() {
        return pcbsRun;
    }

    public void setPcbsRun(int pcbsRun) {
        this.pcbsRun = pcbsRun;
    }
}
