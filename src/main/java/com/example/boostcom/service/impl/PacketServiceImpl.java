package com.example.boostcom.service.impl;

import com.example.boostcom.model.dto.binding.PacketBindingDto;
import com.example.boostcom.model.entities.ChannelEntity;
import com.example.boostcom.model.entities.PacketEntity;
import com.example.boostcom.model.entities.enums.CategoryEnum;
import com.example.boostcom.repository.ChannelRepository;
import com.example.boostcom.repository.ContractUserRepository;
import com.example.boostcom.repository.PacketRepository;
import com.example.boostcom.service.PacketService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacketServiceImpl implements PacketService {

    private final ModelMapper modelMapper;
    private final PacketRepository packetRepository;
    private final ChannelRepository channelRepository;
    private final ContractUserRepository contractUserRepository;

    public PacketServiceImpl(ModelMapper modelMapper,ContractUserRepository contractUserRepository,
                             PacketRepository packetRepository,
                             ChannelRepository channelRepository) {
        this.modelMapper = modelMapper;
        this.contractUserRepository=contractUserRepository;
        this.packetRepository = packetRepository;
        this.channelRepository = channelRepository;

    }

    @Override
    public void savePacket(PacketBindingDto packetDto) {

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
    @Transactional
    @Override
    public void deletePacket(Long id) {
        contractUserRepository.removePacketFromContracts(id);
        packetRepository.deleteById(id);
    }

    @Override
    public List<Double> getPacketPrice() {
        List<PacketEntity> packetEntities = packetRepository.findAll();

      return   packetEntities.stream()
                .map(PacketEntity::priceOfPacket)
                .collect(Collectors.toList());
    }
}
