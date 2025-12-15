package com.example.pcb.repository.entity;

import jakarta.persistence.*;

@Entity
public class SimulationRun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String resultJson;

    public SimulationRun() {}

    public SimulationRun(String resultJson) {
        this.resultJson = resultJson;
    }

    public Long getId() {
        return id;
    }

    public String getResultJson() {
        return resultJson;
    }

    public void setResultJson(String resultJson) {
        this.resultJson = resultJson;
    }
}
