package com.ars.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="APP_REGISTRATION")
public class RegistrationEntity {
	
	@Id
	@SequenceGenerator(name = "app_id_gen",sequenceName = "APPLICATION_ID_GENERATOR",initialValue = 1000,allocationSize = 2)
	@GeneratedValue(generator="app_id_gen",strategy = GenerationType.SEQUENCE)
	private Long applicationId;
	
	@Column(length=50)
	private String fullName;
	
	@Column(length=6)
	private String gender;
	
	@Column(length=50)
	private String mail;
	
	@Column(length=20)
	private String mobileNo;
	
	@Column(length=10)
	private String ssn;
	
	@Column(length=50)
	private String stateName;
	
	private LocalDate dateOfBirth;
	
	@CreationTimestamp
	private LocalDateTime creationTimeStamp;
	
	@UpdateTimestamp
	private LocalDateTime updateTimeStamp;
	
	private String createdBy;
	
	private String updatedBy;
	
	
	

}
