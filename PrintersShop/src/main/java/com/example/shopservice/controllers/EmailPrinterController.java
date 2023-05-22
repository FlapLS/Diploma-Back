package com.example.shopservice.controllers;

import com.example.shopservice.models.EmailDetails;
import com.example.shopservice.service.EmailPrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailPrinterController {
    @Autowired
    private EmailPrinterService emailService;

    // Sending a simple Email
    @PostMapping("/sendMail/")
    public String sendMail(@RequestBody EmailDetails details) {
        String status = emailService.sendSimpleMail(details);
        return status;
    }
}
