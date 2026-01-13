package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.ProjectIdea;
import com.model.Review;

@Service
public class ProjectIdeaDao {
	@Autowired
	ProjectIdeaRepository proIdeaRepo;
	
	public ProjectIdea saveProject(ProjectIdea project) {
	    if (project.getReviews() != null) {
	        for (Review review : project.getReviews()) {
	            review.setId(null); 
	            review.setProjectIdea(project); 
	        }
	    }
	    return proIdeaRepo.save(project);
	}


    // READ Project by ID
    public Optional<ProjectIdea> getProjectById(Long id) {
        return proIdeaRepo.findById(id);
    }

    // READ all Projects
    public List<ProjectIdea> getAllProjects() {
        return proIdeaRepo.findAll();
    }

    // DELETE Project by ID
    public void deleteProject(Long id) {
    	proIdeaRepo.deleteById(id);
    }
    

}