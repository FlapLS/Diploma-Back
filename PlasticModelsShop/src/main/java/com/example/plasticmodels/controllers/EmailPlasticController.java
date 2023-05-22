package com.example.plasticmodels.controllers;

import com.example.plasticmodels.models.EmailDetails;
import com.example.plasticmodels.service.EmailPlasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailPlasticController {

    @Autowired private EmailPlasticService emailService;
    // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailDetails details) {
        String status = emailService.sendSimpleMail(details);
        return status;
    }
}
