package com.chanbar.backend_chanbar.services;


import com.chanbar.backend_chanbar.DTOs.ProjectDTO;

import java.util.List;

public interface IProjectService {
    ProjectDTO createProject(ProjectDTO projectDTO);

    List<ProjectDTO> getAllProjects();

    void deleteProject(Long id);

    ProjectDTO updateProject(Long id, ProjectDTO projectDTO);
}
