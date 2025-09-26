package com.chanbar.backend_chanbar.services;

import com.chanbar.backend_chanbar.DTOs.TeacherDTO;

import java.util.List;

public interface ITeacherService {
    TeacherDTO createTeacher(TeacherDTO teacherDTO);

    List<TeacherDTO> getAllTeachers();

    void deleteTeacher(Long id);

    TeacherDTO updateTeacher(Long id, TeacherDTO teacherDTO);
}
