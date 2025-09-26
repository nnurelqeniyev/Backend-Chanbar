package com.chanbar.backend_chanbar.repositories;

import com.chanbar.backend_chanbar.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
