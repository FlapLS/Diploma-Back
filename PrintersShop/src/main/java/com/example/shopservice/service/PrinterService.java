package com.example.shopservice.service;

import com.example.shopservice.models.PrinterDto;
import com.example.shopservice.domain.Printer;

import java.util.List;

public interface PrinterService {
    void createPrinter(Printer printer);

    void updatePrinter(PrinterDto printerDto,Long id);

    PrinterDto getPrinter(Long id);

    void deletePrinter(Long id);

    List<PrinterDto> findAllPrinter();


}
