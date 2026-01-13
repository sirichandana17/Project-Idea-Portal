package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.ProjectIdea;

@Repository
public interface ProjectIdeaRepository extends JpaRepository<ProjectIdea, Long> {
	
	List<ProjectIdea> findBySubmittedById(Long userId);
    List<ProjectIdea> findByStatus(String status);
}