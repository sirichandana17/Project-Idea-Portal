package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ProjectIdeaRepository;
import com.dao.ReviewRepository;
import com.model.Review;
//import com.service.EmailService;

@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	 private ReviewRepository reviewRepository;
	
	@Autowired
	private ProjectIdeaRepository projectIdeaRepository; // make sure this is injected

	@PostMapping("/save")
	public ResponseEntity<Review> saveOrUpdateReview(@RequestBody Review review) {
	    // Save the review
	    Review savedReview;
	    if (review.getId() != null && reviewRepository.existsById(review.getId())) {
	        Review existingReview = reviewRepository.findById(review.getId()).get();
	        existingReview.setComments(review.getComments());
	        existingReview.setStatus(review.getStatus());
	        existingReview.setProjectIdea(review.getProjectIdea());
	        existingReview.setReviewer(review.getReviewer());
	        savedReview = reviewRepository.save(existingReview);
	    } else {
	        savedReview = reviewRepository.save(review);
	    }

	    // ✅ Also update the corresponding ProjectIdea's status
	    Long ideaId = review.getProjectIdea().getId();
	    projectIdeaRepository.findById(ideaId).ifPresent(projectIdea -> {
	        projectIdea.setStatus(review.getStatus()); // "approved" or "rejected"
	        projectIdeaRepository.save(projectIdea);
	    });

	    return ResponseEntity.ok(savedReview);
	}

    // 🔹 Get All Reviews
    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews() {
        return ResponseEntity.ok(reviewRepository.findAll());
    }

    // 🔹 Get Review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        return reviewRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Delete Review
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}