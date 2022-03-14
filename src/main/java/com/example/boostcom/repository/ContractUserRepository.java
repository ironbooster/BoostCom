package com.example.boostcom.repository;

import com.example.boostcom.model.entities.ContractProviderEntity;
import com.example.boostcom.model.entities.ContractUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContractUserRepository extends JpaRepository<ContractUserEntity,Long> {
    Optional<ContractUserEntity> findById(Long name);
}
