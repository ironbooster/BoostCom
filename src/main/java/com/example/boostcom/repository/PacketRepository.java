package com.example.boostcom.repository;

import com.example.boostcom.model.entities.ChannelEntity;
import com.example.boostcom.model.entities.PacketEntity;
import com.example.boostcom.model.entities.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacketRepository extends JpaRepository<PacketEntity,Long> {

    Optional<PacketEntity> findByName(String name);
    @Modifying
    @Query(nativeQuery = true,value = "delete from packet_channel where channel_id=?1")
    void removeChannel(Long id);
    Optional<PacketEntity> findByCategoryEnum(CategoryEnum categoryEnum);
}
