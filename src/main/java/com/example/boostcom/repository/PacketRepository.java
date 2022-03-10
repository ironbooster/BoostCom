package com.example.boostcom.repository;

import com.example.boostcom.model.entities.ChannelEntity;
import com.example.boostcom.model.entities.PacketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacketRepository extends JpaRepository<PacketEntity,Long> {

    Optional<PacketEntity> findByName(String name);
}
