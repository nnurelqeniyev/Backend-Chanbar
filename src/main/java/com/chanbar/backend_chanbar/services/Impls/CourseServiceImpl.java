package com.chanbar.backend_chanbar.services.Impls;

import com.chanbar.backend_chanbar.DTOs.ProjectDTO;
import com.chanbar.backend_chanbar.DTOs.VacancyDTO;
import com.chanbar.backend_chanbar.DTOs.request.CourseRequestDTO;
import com.chanbar.backend_chanbar.DTOs.response.CourseResponseDTO;
import com.chanbar.backend_chanbar.models.Course;
import com.chanbar.backend_chanbar.models.Project;
import com.chanbar.backend_chanbar.models.SubCategory;
import com.chanbar.backend_chanbar.models.Vacancy;
import com.chanbar.backend_chanbar.repositories.CourseRepository;
import com.chanbar.backend_chanbar.repositories.SubCategoryRepository;
import com.chanbar.backend_chanbar.services.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements ICourseService {
    private final CourseRepository courseRepository;
    private final SubCategoryRepository subCategoryRepository;
    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO courseRequestDTO) {
        Optional<SubCategory> subCategory = subCategoryRepository.findBySubCategoryName(courseRequestDTO.getSubCategory());
        if (subCategory.isPresent()) {
            System.out.println("SubCategory tapıldı: " + subCategory.get().getSubCategoryName());
        } else {
            System.out.println("SubCategory tapılmadı: " + courseRequestDTO.getSubCategory());
        }
        if (subCategory.isPresent()){

            Course course = new Course();
            course.setCourseName(courseRequestDTO.getCourseName());
            course.setCourseDescription(courseRequestDTO.getCourseDescription());
            course.setCoursePrice(courseRequestDTO.getCoursePrice());
            course.setCourseDiscount(courseRequestDTO.getCourseDiscount());
            course.setImgCourse(courseRequestDTO.getImgCourse());
            course.setIsLiked(courseRequestDTO.getIsLiked());
            course.setSubCategory(subCategory.get());
            courseRepository.save(course);
            CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
            courseResponseDTO.setCourseName(course.getCourseName());
            courseResponseDTO.setCourseDescription(course.getCourseDescription());
            courseResponseDTO.setCoursePrice(course.getCoursePrice());
            courseResponseDTO.setCourseDiscount(course.getCourseDiscount());
            courseResponseDTO.setImgCourse(course.getImgCourse());
            courseResponseDTO.setIsLiked(course.getIsLiked());
            courseResponseDTO.setSubCategory(course.getSubCategory().getSubCategoryName());
            return courseResponseDTO;
        }
        return null;
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        List<Course> courseList = courseRepository.findAll();
        List<CourseResponseDTO> courseResponseDTOList = new ArrayList<>();

        for (Course course : courseList){
            CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
            courseResponseDTO.setCourseName(course.getCourseName());
            courseResponseDTO.setCourseDescription(course.getCourseDescription());
            courseResponseDTO.setCoursePrice(course.getCoursePrice());
            courseResponseDTO.setCourseDiscount(course.getCourseDiscount());
            courseResponseDTO.setImgCourse(course.getImgCourse());
            courseResponseDTO.setIsLiked(course.getIsLiked());
            courseResponseDTO.setSubCategory(course.getSubCategory().getSubCategoryName());
            courseResponseDTOList.add(courseResponseDTO);
        }
        return courseResponseDTOList;
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
            courseResponseDTO.setCourseName(course.get().getCourseName());
            courseResponseDTO.setCourseDescription(course.get().getCourseDescription());
            courseResponseDTO.setCoursePrice(course.get().getCoursePrice());
            courseResponseDTO.setCourseDiscount(course.get().getCourseDiscount());
            courseResponseDTO.setImgCourse(course.get().getImgCourse());
            courseResponseDTO.setIsLiked(course.get().getIsLiked());
            courseResponseDTO.setSubCategory(course.get().getSubCategory().getSubCategoryName());
            return courseResponseDTO;
        }
        return null;
    }

    @Override
    public List<CourseResponseDTO> getCourseByName(String courseName) {
        Optional<List<Course>> courses = courseRepository.findByCourseName(courseName);
        if (courses.isPresent()) {
            List<CourseResponseDTO> courseResponseDTOList = new ArrayList<>();

            for (Course course : courses.get()){

                CourseResponseDTO courseResponseDTO = new CourseResponseDTO();
                courseResponseDTO.setCourseName(course.getCourseName());
                courseResponseDTO.setCourseDescription(course.getCourseDescription());
                courseResponseDTO.setCoursePrice(course.getCoursePrice());
                courseResponseDTO.setCourseDiscount(course.getCourseDiscount());
                courseResponseDTO.setImgCourse(course.getImgCourse());
                courseResponseDTO.setIsLiked(course.getIsLiked());
                courseResponseDTO.setSubCategory(course.getSubCategory().getSubCategoryName());
                courseResponseDTOList.add(courseResponseDTO);
                courseResponseDTOList.add(courseResponseDTO);
            }
            return courseResponseDTOList;
        }
        return null;
    }

    @Override
    public List<CourseResponseDTO> getCoursesBySubCategory(String subCategoryName) {
        Optional<SubCategory> subCategory = subCategoryRepository.findBySubCategoryName(subCategoryName);

        if (subCategory.isEmpty()) {
            throw new RuntimeException("SubCategory tapılmadı: " + subCategoryName);
        }

        List<Course> courseList = courseRepository.findBySubCategory(subCategory.get());
        List<CourseResponseDTO> responseList = new ArrayList<>();

        for (Course course : courseList) {
            CourseResponseDTO dto = new CourseResponseDTO();
            dto.setCourseName(course.getCourseName());
            dto.setCourseDescription(course.getCourseDescription());
            dto.setCoursePrice(course.getCoursePrice());
            dto.setCourseDiscount(course.getCourseDiscount());
            dto.setImgCourse(course.getImgCourse());
            dto.setIsLiked(course.getIsLiked());
            dto.setSubCategory(course.getSubCategory().getSubCategoryName());
            responseList.add(dto);
        }

        return responseList;
    }
    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO courseRequestDTO) {
        Optional<Course> course = courseRepository.findById(id);

        if (course.isPresent()) {
            Course course1 = course.get();
            course1.setCourseName(courseRequestDTO.getCourseName());
            course1.setCourseDescription(courseRequestDTO.getCourseDescription());
            course1.setCoursePrice(courseRequestDTO.getCoursePrice());
            course1.setCourseDiscount(courseRequestDTO.getCourseDiscount());
            course1.setImgCourse(courseRequestDTO.getImgCourse());
            course1.setIsLiked(courseRequestDTO.getIsLiked());

            Optional<SubCategory> subCategory = subCategoryRepository.findBySubCategoryName(courseRequestDTO.getSubCategory());
            if (subCategory.isEmpty()) {
                throw new RuntimeException("SubCategory tapılmadı: " + courseRequestDTO.getSubCategory());
            }
            course1.setSubCategory(subCategory.get());

            courseRepository.save(course1);

            CourseResponseDTO courseResponseDTO1 = new CourseResponseDTO();
            courseResponseDTO1.setCourseName(course1.getCourseName());
            courseResponseDTO1.setCourseDescription(course1.getCourseDescription());
            courseResponseDTO1.setCoursePrice(course1.getCoursePrice());
            courseResponseDTO1.setCourseDiscount(course1.getCourseDiscount());
            courseResponseDTO1.setImgCourse(course1.getImgCourse());
            courseResponseDTO1.setIsLiked(course1.getIsLiked());
            courseResponseDTO1.setSubCategory(course1.getSubCategory().getSubCategoryName());
            return courseResponseDTO1;
        }

        return null;
    }

    @Override
    public void deleteCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isPresent()) {
            courseRepository.deleteById(id);
        }
    }
}
