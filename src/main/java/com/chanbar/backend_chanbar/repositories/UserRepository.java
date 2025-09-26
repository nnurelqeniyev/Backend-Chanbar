package com.chanbar.backend_chanbar.repositories;

import com.chanbar.backend_chanbar.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
