package com.chanbar.backend_chanbar.repositories;

import com.chanbar.backend_chanbar.models.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    Optional<List<Vacancy>> findByVacancyName(String vacancyName);
}
