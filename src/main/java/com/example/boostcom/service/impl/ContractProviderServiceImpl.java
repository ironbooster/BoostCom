package com.example.boostcom.service.impl;

import com.example.boostcom.model.dto.binding.ContractProviderBindingDto;
import com.example.boostcom.model.entities.ChannelEntity;
import com.example.boostcom.model.entities.ContractProviderEntity;
import com.example.boostcom.model.entities.ProviderEntity;
import com.example.boostcom.repository.ChannelRepository;
import com.example.boostcom.repository.ContractProviderRepository;
import com.example.boostcom.repository.ProviderRepository;
import com.example.boostcom.service.ContractProviderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractProviderServiceImpl implements ContractProviderService {

     private final ModelMapper modelMapper;
     private final ProviderRepository providerRepository;
     private final ChannelRepository channelRepository;
     private final ContractProviderRepository contractProviderRepository;

    public ContractProviderServiceImpl(ModelMapper modelMapper,
                                       ProviderRepository providerRepository,
                                       ChannelRepository channelRepository,
                                       ContractProviderRepository contractProviderRepository) {
        this.modelMapper = modelMapper;
        this.providerRepository = providerRepository;
        this.channelRepository = channelRepository;
        this.contractProviderRepository = contractProviderRepository;
    }

    @Override
    public void save(ContractProviderBindingDto contractProviderBindingDto) {
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
        }
        return channelEntityList;
    }
}
