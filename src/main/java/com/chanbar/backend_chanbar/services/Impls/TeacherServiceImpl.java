package com.chanbar.backend_chanbar.services.Impls;

import com.chanbar.backend_chanbar.DTOs.TeacherDTO;
import com.chanbar.backend_chanbar.DTOs.VacancyDTO;
import com.chanbar.backend_chanbar.models.Teacher;
import com.chanbar.backend_chanbar.models.Vacancy;
import com.chanbar.backend_chanbar.repositories.TeacherRepository;
import com.chanbar.backend_chanbar.repositories.VacancyRepository;
import com.chanbar.backend_chanbar.services.ITeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements ITeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setTeacher(teacherDTO.getTeacher());
        teacher.setImgTeacher(teacherDTO.getImgTeacher());
        teacher.setTeacherName(teacherDTO.getTeacherName());

        teacherRepository.save(teacher);

        TeacherDTO teacherDTO1 = new TeacherDTO();
        teacherDTO1.setImgTeacher(teacher.getImgTeacher());
        teacherDTO1.setTeacherName(teacher.getTeacherName());
        teacherDTO1.setTeacher(teacher.getTeacher());
        return teacherDTO1;
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        List<Teacher> teacherList = teacherRepository.findAll();
        List<TeacherDTO> teacherDTOList = new ArrayList<>();

        for (Teacher teacher : teacherList){
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.setTeacher(teacher.getTeacher());
            teacherDTO.setTeacherName(teacher.getTeacherName());
            teacherDTO.setImgTeacher(teacher.getImgTeacher());
            teacherDTOList.add(teacherDTO);
        }
        return teacherDTOList;
    }

    @Override
    public void deleteTeacher(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            teacherRepository.deleteById(id);
        }
    }

    @Override
    public TeacherDTO updateTeacher(Long id, TeacherDTO teacherDTO) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        if (teacher.isPresent()) {
            Teacher teacher1 = teacher.get();
            teacher1.setImgTeacher(teacherDTO.getImgTeacher());
            teacher1.setTeacherName(teacherDTO.getTeacherName());
            teacher1.setTeacher(teacherDTO.getTeacher());

            teacherRepository.save(teacher1);
            TeacherDTO teacherDTO1 = new TeacherDTO();
            teacherDTO1.setImgTeacher(teacher1.getImgTeacher());
            teacherDTO1.setTeacherName(teacher1.getTeacherName());
            teacherDTO1.setTeacher(teacher1.getTeacher());
            return teacherDTO1;
        }

        return null;
    }
}
