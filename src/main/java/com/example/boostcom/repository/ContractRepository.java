package com.example.boostcom.repository;

import com.example.boostcom.model.entities.ContractEntity;
import com.example.boostcom.model.entities.PacketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity,Long> {
    Optional<ContractEntity> findById(Long name);
}
