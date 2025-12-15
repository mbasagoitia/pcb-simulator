package com.example.pcb.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class FailureRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pcb_type_id")
    private PcbType pcbType;

    private String stationName;

    private double failureRate;

    public String getStationName() {
        return stationName;
    }

    public double getFailureRate() {
        return failureRate;
    }

}
