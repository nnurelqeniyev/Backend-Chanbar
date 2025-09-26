package com.chanbar.backend_chanbar.controllers;

import com.chanbar.backend_chanbar.DTOs.TeacherDTO;
import com.chanbar.backend_chanbar.DTOs.VacancyDTO;
import com.chanbar.backend_chanbar.services.ITeacherService;
import com.chanbar.backend_chanbar.services.IVacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherController {

    private final ITeacherService teacherService;

    @PostMapping
    TeacherDTO createTeacher(@RequestBody TeacherDTO teacherDTO){
        return teacherService.createTeacher(teacherDTO);
    };

    @GetMapping
    List<TeacherDTO> getAllTeacher(){
        return teacherService.getAllTeachers();
    };

    @DeleteMapping("/{id}")
    void deleteTeacher(@PathVariable(name = "id") Long id){
        teacherService.deleteTeacher(id);
    };

    @PutMapping("/{id}")
    TeacherDTO updateTeacher(@PathVariable(name = "id") Long id, @RequestBody TeacherDTO teacherDTO){
        return teacherService.updateTeacher(id, teacherDTO);
    };
}
