package com.example.boostcom.repository;

import com.example.boostcom.model.entities.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {
}
