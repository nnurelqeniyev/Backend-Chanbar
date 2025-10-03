package com.chanbar.backend_chanbar.controllers;

import com.chanbar.backend_chanbar.DTOs.request.CourseRequestDTO;
import com.chanbar.backend_chanbar.DTOs.response.CourseResponseDTO;
import com.chanbar.backend_chanbar.services.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {
    private final ICourseService courseService;
    @PostMapping
    CourseResponseDTO createCourse(@RequestBody CourseRequestDTO courseRequestDTO){
        return courseService.createCourse(courseRequestDTO);
    }
    @GetMapping
    List<CourseResponseDTO> getAllCourses(){
        return courseService.getAllCourses();
    }
    @GetMapping("/{id}")
    CourseResponseDTO getCourseById(@PathVariable(name = "id") Long id){
        return courseService.getCourseById(id);
    }
    @GetMapping("/search/{name}")
    List<CourseResponseDTO> getCourseByName(@PathVariable(name = "name") String courseName){
        return  courseService.getCourseByName(courseName);
    }
    @GetMapping("/subcategory/{subCategory}")
    List<CourseResponseDTO> getCoursesBySubCategory(@PathVariable(name = "subCategory")String subCategory){
        return courseService.getCoursesBySubCategory(subCategory);
    }
    @PutMapping("/{id}")
    CourseResponseDTO updateCourse(@PathVariable(name = "id") Long id, @RequestBody CourseRequestDTO courseRequestDTO){
        return courseService.updateCourse(id, courseRequestDTO);
    }
    @DeleteMapping("/{id}")
    void deleteCourse(@PathVariable(name = "id") Long id){
        courseService.deleteCourse(id);
    }
}
