package com.example.demo.controller;

import com.example.demo.entity.Email;
import com.example.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class logincontroller {
    @Autowired
    private EmailService emailService;

    @GetMapping("/email")
    public List<Email> getAllEmails() {
        return emailService.findAllEmails();
    }

    @PostMapping("/password")
    public String updatePassword(@RequestBody Email requestBody) {
        return emailService.updatePassword(requestBody.getEmailId(), requestBody.getPassword());
    }
}