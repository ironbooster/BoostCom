package com.example.boostcom.repository;

import com.example.boostcom.model.entities.PacketEntity;
import com.example.boostcom.model.entities.ProviderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderEntity,Long> {

    Optional<ProviderEntity> findByProviderName(String providerName);
}
