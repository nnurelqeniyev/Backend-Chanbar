package com.chanbar.backend_chanbar.services;

import com.chanbar.backend_chanbar.DTOs.VacancyDTO;

import java.util.List;

public interface IVacancyService {
    VacancyDTO createVacancy(VacancyDTO vacancyDTO);
    List<VacancyDTO> getVacancyAllVacancies();
    VacancyDTO getVacancyById(Long id);
    List<VacancyDTO> getVacancyByName(String vacancyName);
    VacancyDTO updateVacancy(Long id, VacancyDTO vacancyDTO);
    void deleteVacancy(Long id);
}
