package com.chanbar.backend_chanbar.repositories;

import com.chanbar.backend_chanbar.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
