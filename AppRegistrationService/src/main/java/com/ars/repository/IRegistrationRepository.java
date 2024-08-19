package com.ars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ars.entity.RegistrationEntity;

public interface IRegistrationRepository extends JpaRepository<RegistrationEntity, Long>{

}
