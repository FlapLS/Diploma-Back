package com.example.shopservice.service;

import com.example.shopservice.models.EmailDetails;
import com.example.shopservice.models.PrinterDto;

public interface EmailPrinterService {

    String sendSimpleMail(EmailDetails details);

}
