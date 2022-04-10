package com.example.boostcom.repository;

import com.example.boostcom.model.entities.ContractProviderEntity;
import com.example.boostcom.model.entities.ContractUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContractUserRepository extends JpaRepository<ContractUserEntity,Long> {
     Optional<ContractUserEntity> findById(Long name);
     @Modifying
     @Query(nativeQuery = true,value = "delete from packet_user_contract where packet_id=?1")
     void removePacketFromContracts(Long id);

}
