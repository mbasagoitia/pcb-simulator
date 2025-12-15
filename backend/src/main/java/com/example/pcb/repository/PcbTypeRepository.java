package com.example.pcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.example.pcb.repository.entity.PcbType;

public interface PcbTypeRepository extends JpaRepository<PcbType, Long> {
    Optional<PcbType> findByName(String name);
}
