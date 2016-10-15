package com.enderase.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Account handling for interaction with the API
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 */
@Entity
@Table(name="account")
public class Account implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2478710608489745748L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="account_id", nullable=false)
	private String accountId;
	
	@Column(name="secret_key", nullable=false)
	private String secretKey;
	
	@Column(name="token", nullable=false)
	private String token;
	
	@Column(name="date_created", nullable=true)
	private Date dateCreated;
	
	public Account(){}//tobe used in JAX-RS

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
