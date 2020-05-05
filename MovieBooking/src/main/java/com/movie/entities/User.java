package com.movie.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;

@Entity
@Table(name="users")
@Inheritance(strategy=InheritanceType.JOINED) 
@DynamicUpdate
@DynamicInsert

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="userId")
public class User  {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;

	@Column(name="password")
	private String password;
	
	@Column(name="username",unique=true,nullable=false)
	private String username;
	
	@Column(name="user_type")
	private UserType userType;
	
	@Column(name="active_sessions")
	private String[] activeSessions;
	
	@Column(name="otp",nullable=true)
	private Long otp;

	@Column(name="is_active",nullable=false)
	private Boolean isActive=true;
	

	public User() {
		super();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	public String[] getActiveSessions() {
		return activeSessions;
	}

	public void setActiveSessions(String[] activeSessions) {
		this.activeSessions = activeSessions;
	}

	public Long getOtp() {
		return otp;
	}

	public void setOtp(Long otp) {
		this.otp = otp;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
	

}
