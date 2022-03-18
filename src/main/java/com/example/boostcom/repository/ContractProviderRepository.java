package com.example.boostcom.repository;

import com.example.boostcom.model.entities.ContractProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractProviderRepository extends JpaRepository<ContractProviderEntity,Long> {
    Optional<ContractProviderEntity> findById(Long name);
}
