package com.chanbar.backend_chanbar.repositories;

import com.chanbar.backend_chanbar.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
        Optional<Category> findById(Long id);


}