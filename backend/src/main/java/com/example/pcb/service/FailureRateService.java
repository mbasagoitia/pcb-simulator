package com.example.pcb.service;

import com.example.pcb.repository.entity.FailureRate;
import com.example.pcb.repository.FailureRateRepository;

import org.springframework.stereotype.Service;

// Service that looks up failure rate per board and station from the Failure Rate Repository

@Service
public class FailureRateService {

    private final FailureRateRepository failureRateRepository;

    public FailureRateService(FailureRateRepository failureRateRepository) {
        this.failureRateRepository = failureRateRepository;
    }

    public double getFailureRate(String pcbTypeName, String stationName) {
        return failureRateRepository
                .findByPcbType_NameAndStationName(pcbTypeName, stationName)
                .map(FailureRate::getFailureRate)
                .orElseThrow(() -> new RuntimeException(
                        "No failure rate found for PCB " + pcbTypeName +
                                " at station " + stationName));
    }
}
