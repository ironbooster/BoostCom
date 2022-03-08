package com.example.boostcom.repository;

import com.example.boostcom.model.entities.ChannelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<ChannelEntity,Long> {
}
