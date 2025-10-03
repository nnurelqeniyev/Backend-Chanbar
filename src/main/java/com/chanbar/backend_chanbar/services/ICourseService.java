package com.chanbar.backend_chanbar.services;

import com.chanbar.backend_chanbar.DTOs.request.CourseRequestDTO;
import com.chanbar.backend_chanbar.DTOs.response.CourseResponseDTO;

import java.util.List;

public interface ICourseService {
    CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO);
    List<CourseResponseDTO> getAllCourses();
    CourseResponseDTO getCourseById(Long id);
    List<CourseResponseDTO> getCourseByName(String courseName);
    List<CourseResponseDTO> getCoursesBySubCategory(String subCategory);
    CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO);
    void deleteCourse(Long id);
}
