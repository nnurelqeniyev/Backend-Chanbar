package com.chanbar.backend_chanbar.services.Impls;

import com.chanbar.backend_chanbar.DTOs.ProjectDTO;
import com.chanbar.backend_chanbar.DTOs.VacancyDTO;
import com.chanbar.backend_chanbar.models.Project;
import com.chanbar.backend_chanbar.models.Vacancy;
import com.chanbar.backend_chanbar.repositories.ProjectRepository;
import com.chanbar.backend_chanbar.repositories.VacancyRepository;
import com.chanbar.backend_chanbar.services.IProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements IProjectService {
    private final ProjectRepository projectRepository;



    @Override
    public ProjectDTO createProject(ProjectDTO projectDTO) {
            Project project = new Project();
            project.setProjectTitle(projectDTO.getProjectTitle());
            project.setDescription(projectDTO.getDescription());
            project.setImgProject(projectDTO.getImgProject());

            projectRepository.save(project);

            ProjectDTO projectDTO1 = new ProjectDTO();
            projectDTO1.setProjectTitle(project.getProjectTitle());
            projectDTO1.setDescription(project.getDescription());
            projectDTO1.setImgProject(project.getImgProject());
            return projectDTO1;

    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projectList = projectRepository.findAll();
        List<ProjectDTO> projectDTOList = new ArrayList<>();

        for (Project project : projectList){
            ProjectDTO projectDTO= new ProjectDTO();
            projectDTO.setImgProject(project.getImgProject());
            projectDTO.setDescription(project.getDescription());
            projectDTO.setProjectTitle(project.getImgProject());
            projectDTOList.add(projectDTO);
        }
        return projectDTOList;
    }

    @Override
    public void deleteProject(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            projectRepository.deleteById(id);
        }
    }

    @Override
    public ProjectDTO updateProject(Long id, ProjectDTO projectDTO) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent()) {
            Project project1 = project.get();
            project1.setProjectTitle(projectDTO.getProjectTitle());
            project1.setDescription(projectDTO.getDescription());
            project1.setImgProject(projectDTO.getImgProject());

            projectRepository.save(project1);

            ProjectDTO projectDTO1= new ProjectDTO();
            projectDTO1.setImgProject(project1.getImgProject());
            projectDTO1.setDescription(project1.getDescription());
            projectDTO1.setProjectTitle(project1.getProjectTitle());
            return projectDTO1;
        }

        return null;
    }
}
