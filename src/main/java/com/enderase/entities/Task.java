package com.enderase.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Task entity - a mapper class for task table in the table.
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 *
 */
@Entity
@Table(name="task")
@XmlRootElement
public class Task implements Serializable{

	private static final long serialVersionUID = -8885747627755708737L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="title", nullable=false)
	private String title;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@Column(name="dead_line", nullable=true)
	private Date deadLine;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner owner;
	
	@Column(name="date_created", nullable=false)
	private Date dateCreated;
	
	@Column(name="date_modified", nullable=false)
	private Date dateModified;
	
	public Task(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public Owner getOwnerId() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}
}
