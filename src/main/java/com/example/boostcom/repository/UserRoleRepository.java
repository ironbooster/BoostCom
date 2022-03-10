package com.example.boostcom.repository;

import com.example.boostcom.model.entities.UserRoleEntity;
import com.example.boostcom.model.entities.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {
    Optional<UserRoleEntity> findByRole(UserRoleEnum role);

}
