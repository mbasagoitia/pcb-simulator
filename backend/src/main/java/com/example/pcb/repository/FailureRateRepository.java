package com.example.pcb.repository;

import com.example.pcb.repository.entity.FailureRate;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface FailureRateRepository extends JpaRepository<FailureRate, Long> {

    Optional<FailureRate> findByPcbType_NameAndStationName(String pcbTypeName, String stationName);

    List<FailureRate> findByPcbTypeName(String pcbTypeName);
}
