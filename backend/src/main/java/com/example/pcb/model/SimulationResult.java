package com.example.pcb.model;

import java.util.Map;

// Model representing the result of a single simulation run

public class SimulationResult {

    private String boardType;
    private int pcbsRun;
    private int totalSuccesses;
    private int totalFailures;

    private Map<String, Integer> stationFailures;
    private Map<String, Integer> pcbDefectFailures;

    public SimulationResult() {}

    public SimulationResult(String boardType, int pcbsRun, int totalSuccesses, int totalFailures,
                            Map<String, Integer> stationFailures, Map<String, Integer> pcbDefectFailures) {
        this.boardType = boardType;
        this.pcbsRun = pcbsRun;
        this.totalSuccesses = totalSuccesses;
        this.totalFailures = totalFailures;
        this.stationFailures = stationFailures;
        this.pcbDefectFailures = pcbDefectFailures;
    }

    public String getBoardType() {
        return boardType;
    }

    public int getPcbsRun() {
        return pcbsRun;
    }

    public int getTotalSuccesses() {
        return totalSuccesses;
    }

    public int getTotalFailures() {
        return totalFailures;
    }

    public Map<String, Integer> getStationFailures() {
        return stationFailures;
    }

    public Map<String, Integer> getPcbDefectFailures() {
        return pcbDefectFailures;
    }

    public void setBoardType(String boardType) {
        this.boardType = boardType;
    }

    public void setPcbsRun(int pcbsRun) {
        this.pcbsRun = pcbsRun;
    }

    public void setTotalSuccesses(int totalSuccesses) {
        this.totalSuccesses = totalSuccesses;
    }

    public void setTotalFailures(int totalFailures) {
        this.totalFailures = totalFailures;
    }

    public void setStationFailures(Map<String, Integer> stationFailures) {
        this.stationFailures = stationFailures;
    }

    public void setPcbDefectFailures(Map<String, Integer> pcbDefectFailures) {
        this.pcbDefectFailures = pcbDefectFailures;
    }
}
