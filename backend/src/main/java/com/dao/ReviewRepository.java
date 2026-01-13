package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.ProjectIdea;
import com.model.Review;



@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	 List<Review> findByReviewerId(Long reviewerId);

	    List<Review> findByProjectIdeaId(Long projectIdeaId);

	    List<Review> findByStatus(String status);

}