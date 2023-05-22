package com.example.shopservice.controllers;


import com.example.shopservice.common.Endpoints;
import com.example.shopservice.common.Logger;
import com.example.shopservice.domain.PrinterRepository;
import com.example.shopservice.models.PrinterDto;
import com.example.shopservice.domain.Printer;
import com.example.shopservice.service.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@RestController
public class PrinterController {

    @Autowired
    private PrinterService printerService;
    @Autowired
    PrinterRepository printerRepository;
    @Autowired
    private Logger logger;

    @PostMapping(Endpoints.BasicOperationPrinter.PRINTER_CREATE)
    public ResponseEntity<Object> createPrinter(@RequestBody Printer printer) {
        logger.info("createPrinter", printer);
        printerService.createPrinter(printer);
        return ResponseEntity.ok().build();
    }

    @GetMapping(Endpoints.BasicOperationPrinter.PRINTER_GET)
    public ResponseEntity<PrinterDto> getPrinter(@PathVariable Long printersId) {
        logger.info("getPrinter", printersId);
        return ResponseEntity.ok(printerService.getPrinter(printersId));
    }

    @DeleteMapping(Endpoints.BasicOperationPrinter.PRINTER_DELETE)
    public ResponseEntity<PrinterDto> deletePrinter(@PathVariable Long printersId) {
        logger.info("deletePrinter", printersId);
        printerService.deletePrinter(printersId);
        return ResponseEntity.ok().build();
    }

    @PutMapping(Endpoints.BasicOperationPrinter.PRINTER_UPDATE)
    public ResponseEntity<Object> updatePrinter(@RequestBody PrinterDto printerDto, @PathVariable Long printersId) {
        logger.info("updatePrinter", printerDto);
        printerService.updatePrinter(printerDto, printersId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(Endpoints.BasicOperationPrinter.PRINTER_ALL)
    public ResponseEntity<List<PrinterDto>> getAllPrinters() {
        logger.info("getAllPrinters","");
        return ResponseEntity.ok(printerService.findAllPrinter());
    }

}
