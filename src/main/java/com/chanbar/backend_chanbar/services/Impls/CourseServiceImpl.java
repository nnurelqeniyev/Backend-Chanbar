package com.chanbar.backend_chanbar.services.Impls;

import com.chanbar.backend_chanbar.DTOs.request.CourseRequestDTO;
import com.chanbar.backend_chanbar.DTOs.response.CourseResponseDTO;
import com.chanbar.backend_chanbar.repositories.CourseRepository;
import com.chanbar.backend_chanbar.services.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {
    private final CourseRepository courseRepository;

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        return null;
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return List.of();
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        return null;
    }

    @Override
    public List<CourseResponseDTO> getCourseByName(String courseName) {
        return List.of();
    }

    @Override
    public List<CourseResponseDTO> getCoursesBySubCategory(String subCategory) {
        return List.of();
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {

    }
}
