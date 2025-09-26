package com.chanbar.backend_chanbar.services.Impls;

import com.chanbar.backend_chanbar.DTOs.VacancyDTO;
import com.chanbar.backend_chanbar.models.Vacancy;
import com.chanbar.backend_chanbar.repositories.VacancyRepository;
import com.chanbar.backend_chanbar.services.IVacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements IVacancyService {

    private final VacancyRepository vacancyRepository;

    @Override
    public VacancyDTO createVacancy(VacancyDTO vacancyDTO) {


        Vacancy vacancy = new Vacancy();
        vacancy.setVacancyName(vacancyDTO.getVacancyName());
        vacancy.setDescription(vacancyDTO.getDescription());

        vacancyRepository.save(vacancy);

        VacancyDTO vacancyDTO1 = new VacancyDTO();
        vacancyDTO1.setVacancyName(vacancy.getVacancyName());
        vacancyDTO1.setDescription(vacancy.getDescription());
        return vacancyDTO1;
    }

    @Override
    public List<VacancyDTO> getVacancyAllVacancies() {
        List<Vacancy> vacancyList = vacancyRepository.findAll();
        List<VacancyDTO> vacancyDTOList = new ArrayList<>();

        for (Vacancy vacancy : vacancyList){
            VacancyDTO vacancyDTO = new VacancyDTO();
            vacancyDTO.setVacancyName(vacancy.getVacancyName());
            vacancyDTO.setDescription(vacancy.getDescription());
            vacancyDTOList.add(vacancyDTO);
        }
        return vacancyDTOList;
    }

    @Override
    public VacancyDTO getVacancyById(Long id) {
        Optional<Vacancy> vacancy = vacancyRepository.findById(id);
        if (vacancy.isPresent()) {
            VacancyDTO vacancyDTO = new VacancyDTO();
            vacancyDTO.setVacancyName(vacancy.get().getVacancyName());
            vacancyDTO.setDescription(vacancy.get().getDescription());
        }
        return null;
    }


    @Override
    public VacancyDTO updateVacancy(Long id, VacancyDTO vacancyDTO) {
        Optional<Vacancy> vacancy = vacancyRepository.findById(id);
        if (vacancy.isPresent()) {
            Vacancy vacancy1= vacancy.get();
            vacancy1.setVacancyName(vacancy1.getVacancyName());
            vacancy1.setDescription(vacancy1.getDescription());

            vacancyRepository.save(vacancy1);
            VacancyDTO vacancyDTO1 = new VacancyDTO();
            vacancyDTO1.setVacancyName(vacancyDTO1.getVacancyName());
            vacancyDTO1.setDescription(vacancyDTO1.getDescription());
            return vacancyDTO1;
        }

        return null;
    }

    @Override
    public void deleteVacancy(Long id) {
        Optional<Vacancy> vacancy = vacancyRepository.findById(id);
        if (vacancy.isPresent()) {
            vacancyRepository.deleteById(id);
        }
    }

    @Override
    public List<VacancyDTO> getVacancyByName(String vacancyName){
        Optional<List<Vacancy>> vacancies = vacancyRepository.findByVacancyName(vacancyName);
        if (vacancies.isPresent()) {
            List<VacancyDTO> vacancyDTOList = new ArrayList<>();

            for (Vacancy vacancy : vacancies.get()){
                VacancyDTO vacancyDTO = new VacancyDTO();
                vacancyDTO.setVacancyName(vacancy.getVacancyName());
                vacancyDTO.setDescription(vacancy.getDescription());
                vacancyDTOList.add(vacancyDTO);
            }
            return vacancyDTOList;
        }
        return null;
    }
}
