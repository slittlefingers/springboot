package com.example.demo.repository;

import com.example.demo.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmailRepository extends JpaRepository<Email, Integer> {
    Optional<Email> findByEmailId(String emailId);
}