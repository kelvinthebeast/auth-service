package com.nhanthanhle.research.identity_service.repository;

import com.nhanthanhle.research.identity_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
}
