package com.example.boostcom.service.impl;

import com.example.boostcom.model.dto.binding.PacketBindingDto;
import com.example.boostcom.model.entities.ChannelEntity;
import com.example.boostcom.model.entities.PacketEntity;
import com.example.boostcom.model.entities.enums.CategoryEnum;
import com.example.boostcom.repository.ChannelRepository;
import com.example.boostcom.repository.PacketRepository;
import com.example.boostcom.service.PacketService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacketServiceImpl implements PacketService {

    private final ModelMapper modelMapper;
    private final PacketRepository packetRepository;
    private final ChannelRepository channelRepository;

    public PacketServiceImpl(ModelMapper modelMapper,
                             PacketRepository packetRepository,
                             ChannelRepository channelRepository) {
        this.modelMapper = modelMapper;
        this.packetRepository = packetRepository;
        this.channelRepository = channelRepository;
    }

    @Override
    public void save(PacketBindingDto packetDto) {

        PacketEntity packetEntity = modelMapper.map(packetDto, PacketEntity.class);
        packetEntity.setChannels(channelEntityConvert(packetDto.getChannels()));
        packetEntity.setCategoryEnum(CategoryEnum.Mixed);
        packetRepository.save(packetEntity);

    }

    private List<ChannelEntity> channelEntityConvert(List<String> channels){
        return channels.stream().map(ch-> channelRepository
                .findByChannelName(ch).orElse(null))
                .collect(Collectors.toList());
    }
}
