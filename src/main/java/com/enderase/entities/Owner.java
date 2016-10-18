package com.enderase.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity class for owner of the task
 * 
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 */
@Entity
@Table(name="owner")
@XmlRootElement
public class Owner implements Serializable{
	
	private static final long serialVersionUID = -956303104059638013L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="first_name", nullable=true)
	private String firstName;
	
	@Column(name="last_name", nullable=true)
	private String lastName;
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="username", nullable=false)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="date_created")
	private Date dateCreated;

	public Owner(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
