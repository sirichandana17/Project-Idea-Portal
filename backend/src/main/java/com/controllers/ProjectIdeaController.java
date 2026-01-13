package com.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dao.ProjectIdeaDao;
import com.model.ProjectIdea;
import com.dao.UserRepository;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "*") // Allow frontend requests (if from a different origin)
public class ProjectIdeaController {

    @Autowired
    private ProjectIdeaDao proIdeaDao;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("createOrUpdateProject")
    public ProjectIdea createOrUpdateProject(@RequestBody ProjectIdea project) {
        // Fetch and attach the actual User entity from DB
        if (project.getSubmittedBy() != null && project.getSubmittedBy().getId() != null) {
            userRepo.findById(project.getSubmittedBy().getId())
                .ifPresent(project::setSubmittedBy);
        } else {
            project.setSubmittedBy(null); // Or handle error if user must be present
        }

        return proIdeaDao.saveProject(project);
    }

    @GetMapping("getProjectById/{id}")
    public Optional<ProjectIdea> getProjectById(@PathVariable Long id) {
        return proIdeaDao.getProjectById(id);
    }

    @GetMapping("getAllProjects")
    public List<ProjectIdea> getAllProjects() {
        return proIdeaDao.getAllProjects();
    }

    @DeleteMapping("deleteProject/{id}")
    public void deleteProject(@PathVariable Long id) {
        proIdeaDao.deleteProject(id);
    }
}
