package com.example.shopservice.service.Imp;

import com.example.shopservice.domain.Shop;
import com.example.shopservice.domain.ShopRepository;
import com.example.shopservice.service.PrinterService;
import com.example.shopservice.utils.ModelMapper;
import com.example.shopservice.models.PrinterDto;
import com.example.shopservice.domain.Printer;
import com.example.shopservice.domain.PrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Format;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrinterServiceImp implements PrinterService {

    @Autowired
    private PrinterRepository printerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createPrinter(Printer printer) {
        Printer printerCreate = new Printer();
        printerCreate.setPrinterId(printer.getPrinterId());
        printerCreate.setName(printer.getName());
        printerCreate.setCompany(printer.getCompany());
        printerCreate.setType(printer.getType());
        printerCreate.setPhoto(printer.getPhoto());
        printerCreate.setAmount(printer.getAmount());
        printerCreate.setCreationDate(LocalDateTime.now());
        printerRepository.save(printerCreate);
    }

    @Override
    public void updatePrinter(PrinterDto printerDto, Long id) {
        Printer printer = printerRepository.findById(id).orElseThrow();
        printer.setName(printerDto.getName());
        printer.setCompany(printerDto.getCompany());
        printer.setType(printerDto.getType());
        printer.setPhoto(printerDto.getPhoto());
        printer.setAmount(printerDto.getAmount());
        printerRepository.save(printer);
    }

    @Override
    public PrinterDto getPrinter(Long id) {
        return modelMapper.map(printerRepository.findById(id).orElseThrow());
    }

    @Override
    public void deletePrinter(Long id) {
        Printer printer = printerRepository.findById(id).orElseThrow();
        printerRepository.delete(printer);
    }

    @Override
    public List<PrinterDto> findAllPrinter() {
        return printerRepository.findAll()
                .stream()
                .map(modelMapper::map)
                .collect(Collectors.toList());
    }
}
