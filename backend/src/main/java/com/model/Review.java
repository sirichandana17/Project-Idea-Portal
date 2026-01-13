package com.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "project_id")
	@JsonBackReference
	private ProjectIdea projectIdea;

    @ManyToOne
    @JoinColumn(name = "reviewer_id", nullable = false)
    private User reviewer; 

    @Column(length = 1000)
    private String comments; 
    
    private String status; 

    @CreationTimestamp
    private LocalDateTime reviewedAt;
    
    @Version
    private int version;


	public Review() {
		
	}

	public Review(Long id, ProjectIdea projectIdea, User reviewer, String comments, String status,
			LocalDateTime reviewedAt) {
		
		this.id = id;
		this.projectIdea = projectIdea;
		this.reviewer = reviewer;
		this.comments = comments;
		this.status = status;
		this.reviewedAt = reviewedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProjectIdea getProjectIdea() {
		return projectIdea;
	}

	public void setProjectIdea(ProjectIdea projectIdea) {
		this.projectIdea = projectIdea;
	}

	public User getReviewer() {
		return reviewer;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getReviewedAt() {
		return reviewedAt;
	}

	public void setReviewedAt(LocalDateTime reviewedAt) {
		this.reviewedAt = reviewedAt;
	}
    

}