package com.example.boostcom;

import com.example.boostcom.model.entities.*;
import com.example.boostcom.model.entities.enums.CategoryEnum;
import com.example.boostcom.model.entities.enums.UserRoleEnum;
import com.example.boostcom.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class DBInit implements CommandLineRunner {


    ChannelRepository channelRepository;
    ContractProviderRepository contractProviderRepository;
    ContractUserRepository contractUserRepository;
    PacketRepository packetRepository;
    ProviderRepository providerRepository;
    UserRepository userRepository;
    UserRoleRepository userRoleRepository;


    public DBInit(ChannelRepository channelRepository,
                  ContractProviderRepository contractProviderRepository,
                  ContractUserRepository contractUserRepository,
                  PacketRepository packetRepository,
                  ProviderRepository providerRepository,
                  UserRepository userRepository,
                  UserRoleRepository userRoleRepository) {
        this.channelRepository = channelRepository;
        this.contractProviderRepository = contractProviderRepository;
        this.contractUserRepository = contractUserRepository;
        this.packetRepository = packetRepository;
        this.providerRepository = providerRepository;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {

   contractProviderInit();
   packetCreation();
   userRegister();
   contractUser();



    }
    private void contractUser(){
        ContractUserEntity contractUser = new ContractUserEntity();
        Optional<UserEntity> user1 = userRepository.findByUsername("iv_d");
        contractUser.setPrice(123).setPacketEntities(List.of(packetRepository.getById(1L)));
        contractUserRepository.save(contractUser);
        List<ContractUserEntity> contractsss = contractUserRepository.findAll();
        user1.get().setContract(contractsss);
    }
    private void  userRegister(){
        UserRoleEntity userrole = new UserRoleEntity();
        userrole.setRole(UserRoleEnum.Admin);
        userRoleRepository.save(userrole);
        UserEntity user = new UserEntity();
        userrole.setRole(UserRoleEnum.Admin);
        user.setEmail("asas@abv.bg").setFirstName("Ivailo")
                .setUsername("iv_d").setPassword("asd123").setLastName("Aleksandrov")
                .setRoles(List.of(userrole));
        userRepository.save(user);

    }

    private void packetCreation(){
        PacketEntity packetEntity = new PacketEntity();
        List<ChannelEntity> channels = channelRepository.findAll();
        packetEntity.setName("Family Packet");
        packetEntity.setChannels(channels);
        packetRepository.save(packetEntity);



    }

    private void contractProviderInit(){
        ProviderEntity providerEntity = new ProviderEntity();
        ProviderEntity providerEntity2 = new ProviderEntity();
        providerEntity.setProviderName("Nova");
        providerRepository.save(providerEntity);
        providerEntity2.setProviderName("BTV");
        providerRepository.save(providerEntity2);
        ChannelEntity channel = new ChannelEntity();
        ChannelEntity channe2 = new ChannelEntity();
        channel.setChannelName("Diema").setChannelCategoryEnum(CategoryEnum.Movie)
                .setPrice(1.50);
        channelRepository.save(channel);
        channe2.setPrice(2).setChannelName("Discovery").setChannelCategoryEnum(CategoryEnum.Scientific);
        channelRepository.save(channe2);
        ContractProviderEntity contractProvider = new ContractProviderEntity();
        contractProvider.setPrice(1500.40).setProviderEntity(providerEntity)
                .setChannelEntityList(List.of(channel));
        contractProviderRepository.save(contractProvider);
        ContractProviderEntity contractProvider1 = new ContractProviderEntity();
        contractProvider1.setProviderEntity(providerEntity).setPrice(2000)
                .setChannelEntityList(List.of(channe2));
        contractProviderRepository.save(contractProvider1);


    }
}
