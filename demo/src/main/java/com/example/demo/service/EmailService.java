package com.example.demo.service;

import com.example.demo.entity.Email;
import com.example.demo.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    @Autowired
    private EmailRepository emailRepository;

    public List<Email> findAllEmails() {
        return emailRepository.findAll();
    }

    public String updatePassword(String emailId, String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);

        return emailRepository.findByEmailId(emailId)
                .map(email -> {
                    email.setPassword(hashedPassword);
                    emailRepository.save(email);
                    return "Password updated";
                }).orElse("User not exist");
    }
}