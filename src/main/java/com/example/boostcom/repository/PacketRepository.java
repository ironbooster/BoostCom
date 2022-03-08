package com.example.boostcom.repository;

import com.example.boostcom.model.entities.PacketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacketRepository extends JpaRepository<PacketEntity,Long> {
}
