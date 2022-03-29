package com.example.boostcom.service.impl;

import com.example.boostcom.model.dto.binding.ContractUserBindingDto;
import com.example.boostcom.model.entities.ChannelEntity;
import com.example.boostcom.model.entities.ContractUserEntity;
import com.example.boostcom.model.entities.PacketEntity;
import com.example.boostcom.model.entities.UserEntity;
import com.example.boostcom.repository.ContractUserRepository;
import com.example.boostcom.repository.PacketRepository;
import com.example.boostcom.repository.UserRepository;
import com.example.boostcom.service.ContractUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class ContractUserServiceImpl implements ContractUserService {

    private final ModelMapper modelMapper;
    private final ContractUserRepository contractUserRepository;
    private final PacketRepository packetRepository;
    private final UserRepository userRepository;

    public ContractUserServiceImpl(ModelMapper modelMapper,
                                   UserRepository userRepository,
                                   PacketRepository packetRepository,
                                   ContractUserRepository contractUserRepository) {
        this.modelMapper = modelMapper;
        this.userRepository=userRepository;
        this.packetRepository=packetRepository;
        this.contractUserRepository = contractUserRepository;
    }

    @Override
    public void save(ContractUserBindingDto contractUserBindingDto) {
        ContractUserEntity contractUserEntity = modelMapper.map(contractUserBindingDto,
                ContractUserEntity.class);
        contractUserEntity.setPacketEntities(packetEntityConverter(contractUserBindingDto));
        contractUserEntity.setPrice(contractPrice(contractUserBindingDto));
        contractUserRepository.save(contractUserEntity);
        UserEntity userEntity = userRepository.
                findByUsername(contractUserBindingDto.
                        getUsername()).orElse(null);


        if (userEntity != null) {
            userEntity.getContract().add(contractUserEntity);
            userRepository.save(userEntity);
        }

    }

    private List<PacketEntity> packetEntityConverter(ContractUserBindingDto contractUserBindingDto){
        List<Optional<PacketEntity>> packets= contractUserBindingDto.getPackets().stream()
                .map(packetRepository::findByName).collect(Collectors.toList());
        return packets.stream().flatMap(Optional::stream).collect(Collectors.toList());

    }
    private double contractPrice(ContractUserBindingDto contractUserBindingDto){
     List<PacketEntity> packetEntities=
        contractUserBindingDto.getPackets()
                .stream()
                .map(pName->packetRepository.findByName(pName).orElse(null))
                .collect(Collectors.toList());

     List<ChannelEntity> channelEntities=packetEntities
             .stream().map(PacketEntity::getChannels)
             .flatMap(List::stream).collect(Collectors.toList());

        Optional<ChannelEntity> optionalChannel = channelEntities.stream().findFirst();
        if(optionalChannel.isPresent()){
            return channelEntities.stream()
                    .map(ChannelEntity::getPrice).mapToDouble(p->p).sum();
        }
          return 0;
    }
}
