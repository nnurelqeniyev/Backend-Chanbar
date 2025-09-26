package com.chanbar.backend_chanbar.controllers;

import com.chanbar.backend_chanbar.DTOs.ProjectDTO;
import com.chanbar.backend_chanbar.DTOs.VacancyDTO;
import com.chanbar.backend_chanbar.services.IProjectService;
import com.chanbar.backend_chanbar.services.IVacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/project")
public class ProjectController {
    private final IProjectService projectService;

    @PostMapping
    ProjectDTO createProject(@RequestBody ProjectDTO projectDTO){
        return projectService.createProject(projectDTO);
    };
    @GetMapping
    List<ProjectDTO> getAllProjects(){
        return projectService.getAllProjects();
    };
    @PutMapping("/{id}")
    ProjectDTO updateProject(@PathVariable(name = "id") Long id, @RequestBody ProjectDTO projectDTO){
        return projectService.updateProject(id, projectDTO);
    };
    @DeleteMapping("/{id}")
    void deleteProject(@PathVariable(name = "id") Long id){
        projectService.deleteProject(id);
    };

}
