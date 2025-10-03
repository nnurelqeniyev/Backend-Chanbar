package com.chanbar.backend_chanbar.repositories;

import com.chanbar.backend_chanbar.models.Course;
import com.chanbar.backend_chanbar.models.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<List<Course>> findByCourseName(String courseName);
    List<Course> findBySubCategory(SubCategory subCategory);
}
