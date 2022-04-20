package com.example.boostcom.service.impl;

import com.example.boostcom.model.dto.binding.ContractProviderBindingDto;
import com.example.boostcom.model.entities.ChannelEntity;
import com.example.boostcom.model.entities.ContractProviderEntity;
import com.example.boostcom.model.entities.PacketEntity;
import com.example.boostcom.model.entities.ProviderEntity;
import com.example.boostcom.repository.ChannelRepository;
import com.example.boostcom.repository.ContractProviderRepository;
import com.example.boostcom.repository.PacketRepository;
import com.example.boostcom.repository.ProviderRepository;
import com.example.boostcom.service.ContractProviderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ContractProviderServiceImpl implements ContractProviderService {

     private final ModelMapper modelMapper;
     private final ProviderRepository providerRepository;
     private final PacketRepository packetRepository;
     private final ChannelRepository channelRepository;
     private final ContractProviderRepository contractProviderRepository;

    public ContractProviderServiceImpl(ModelMapper modelMapper,
                                       PacketRepository packetRepository,
                                       ProviderRepository providerRepository,
                                       ChannelRepository channelRepository,
                                       ContractProviderRepository contractProviderRepository) {
        this.modelMapper = modelMapper;
        this.providerRepository = providerRepository;
        this.channelRepository = channelRepository;
        this.contractProviderRepository = contractProviderRepository;
        this.packetRepository=packetRepository;
    }
    @Transactional
    @Override
    public void deleteProviderContractById(long id) {
        ContractProviderEntity contractProvider=contractProviderRepository.getById(id);
        providerRepository.deleteById(contractProvider.getProviderEntity().getId());

        for(ChannelEntity ch : contractProvider.getChannelEntityList()){
        packetRepository.removeChannel(ch.getId());
        }
      contractProviderRepository.deleteById(id);
    }

    @Override
    public void saveProviderContract(ContractProviderBindingDto contractProviderBindingDto) {
        ContractProviderEntity contractProviderEntity = modelMapper.
                map(contractProviderBindingDto, ContractProviderEntity.class);
        contractProviderEntity.setDateStarted(contractProviderBindingDto.getStartDate());
        contractProviderEntity.setProviderEntity(
                asNewProvider(contractProviderBindingDto.getProviderName()));
        contractProviderEntity.setChannelEntityList(channelEntityConverter(contractProviderBindingDto));
        contractProviderRepository.save(contractProviderEntity);


    }

    private ProviderEntity asNewProvider(String providerName){
        ProviderEntity providerEntity = new ProviderEntity();
        providerEntity.setProviderName(providerName);
        providerRepository.save(providerEntity);
        return providerEntity;
    }

    private List<ChannelEntity> channelEntityConverter(ContractProviderBindingDto contractProviderBindingDto){
        List<ChannelEntity> channelEntityList = new ArrayList<>();
        for(int i=0;i<contractProviderBindingDto.getChannels().size();i++){
            ChannelEntity channelEntity = new ChannelEntity();
            channelEntity.setChannelName(contractProviderBindingDto.getChannels().get(i));
            channelEntity.setPrice(contractProviderBindingDto.getChannelPrices().get(i));
            channelEntity.setChannelCategoryEnum(contractProviderBindingDto.getCategory().get(i));
            channelRepository.save(channelEntity);
            channelEntityList.add(channelEntity);
            saveChannelToEnumPacket(channelEntity);
        }
        return channelEntityList;
    }
    @Transactional
    @Override
    public void discountChannelsPrice(int discPercentage) {
         contractProviderRepository.discountChannelsPrice(discPercentage);
    }

    @Transactional
    @Override
    public void increaseChannelsPrice(int incPercentage) {
        contractProviderRepository.increaseChannelsPrice(incPercentage);
    }
    private void saveChannelToEnumPacket(ChannelEntity channel){
       PacketEntity packet= packetRepository
               .findByCategoryEnum(channel.getChannelCategoryEnum())
               .orElseThrow();
       packet.addChannel(channel);
       packetRepository.save(packet);
    }
}
