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
@Table(name="category")
@XmlRootElement
public class Category implements Serializable{

	private static final long serialVersionUID = -858130063685050563L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="name_short", nullable=false)
	private String nameShort;
	
	@Column(name="description", nullable=true)
	private String description;
	
	@Column(name="date_created")
	private Date dateCreated;

	public Category(){}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getNameShort() {
		return nameShort;
	}
	
	public void setNameShort(String nameShort) {
		this.nameShort = nameShort;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
