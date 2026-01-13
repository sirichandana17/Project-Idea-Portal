package com.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class ProjectIdea {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String title; 

    @Column(length = 1000)
    private String description; 
    
    private String domain; 

    @ManyToOne
    @JoinColumn(name = "submitted_by", nullable = true)  
    private User submittedBy;
    
    @OneToMany(mappedBy = "projectIdea", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Review> reviews;

    private String status = "Pending"; 

    @CreationTimestamp
    private LocalDateTime submittedAt;
    
    public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getProjectLink() {
		return projectLink;
	}

	public void setProjectLink(String projectLink) {
		this.projectLink = projectLink;
	}

	@Column(name = "project_link")
    private String projectLink;


	public ProjectIdea() {
		
	}

	public ProjectIdea(Long id, String title, String description, String domain, User submittedBy, String status,
			LocalDateTime submittedAt) {
	
		this.id = id;
		this.title = title;
		this.description = description;
		this.domain = domain;
		this.submittedBy = submittedBy;
		this.status = status;
		this.submittedAt = submittedAt;
	}

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

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public User getSubmittedBy() {
		return submittedBy;
	}

	public void setSubmittedBy(User submittedBy) {
		this.submittedBy = submittedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getSubmittedAt() {
		return submittedAt;
	}

	public void setSubmittedAt(LocalDateTime submittedAt) {
		this.submittedAt = submittedAt;
	}
    
    

}