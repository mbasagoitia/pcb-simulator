package com.example.pcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pcb.repository.entity.SimulationRun;

public interface SimulationRunRepository extends JpaRepository<SimulationRun, Long> {
}
