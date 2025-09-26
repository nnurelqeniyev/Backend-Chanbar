package com.chanbar.backend_chanbar.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private String projectTitle;
    private String description;
    private String imgProject;

}