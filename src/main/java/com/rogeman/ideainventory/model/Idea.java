package com.rogeman.ideainventory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="idea")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"createdAt", "updatedAt"}, allowGetters=true)
public class Idea {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="idea")
	private String idea;
	

	
	//@NotBlank
	@Column(name="parentIdeaId", columnDefinition="BIGINT(20) DEFAULT 0")
	private int parentIdeaId;
	
	@Column(nullable=false, updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;

	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	public Idea() {
		
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Idea(String idea, int parentIdeaId) {
	
		this.idea = idea;

		this.parentIdeaId = parentIdeaId;
	}

	public int getParentIdeaId() {
		return parentIdeaId;
	}

	public void setParentIdeaId(int parentIdeaId) {
		this.parentIdeaId = parentIdeaId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}


	@Override
	public String toString() {
		return "Idea [id=" + id + ", idea=" + idea + ", parentIdeaId=" + parentIdeaId + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
	

}
