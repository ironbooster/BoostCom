package com.example.boostcom.repository;

import com.example.boostcom.model.entities.ChannelEntity;
import com.example.boostcom.model.entities.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChannelRepository extends JpaRepository<ChannelEntity,Long> {

    Optional<ChannelEntity> findByChannelName(String channelName);

    List<ChannelEntity> findByChannelCategoryEnum(CategoryEnum category);
}
