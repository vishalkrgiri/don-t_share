package com.movie.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@Entity
@Table
@DynamicInsert
@DynamicUpdate

@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property="userId")
public class Admin extends User{	
	
	@Column(name="admin_name")
	private String adminName;
	
	@Column(name="admin_contact",unique=true)
	private String adminContact;

	
	
	public Admin() {
		super();
	}


	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}
	
	
	
}
