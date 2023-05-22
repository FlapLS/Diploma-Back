package com.example.shopservice.utils;

import com.example.shopservice.domain.Shop;
import com.example.shopservice.models.PrinterDto;
import com.example.shopservice.domain.Printer;
import com.example.shopservice.models.ShopDto;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class ModelMapper {
    public PrinterDto map(Printer printer) {
        PrinterDto printerDto = new PrinterDto();
        printerDto.setId(printer.getPrinterId());
        printerDto.setName(printer.getName());
        printerDto.setCompany(printer.getCompany());
        printerDto.setType(printer.getType());
        printerDto.setPhoto(printer.getPhoto());
        printerDto.setAmount(printer.getAmount());
        printerDto.setCreationDate(printer.getCreationDate());
        return printerDto;
    }
    public ShopDto map(Shop shop) {
        ShopDto shopDto = new ShopDto();
        shopDto.setShopId(shop.getShopId());
        shopDto.setName(shop.getName());
        shopDto.setUrl(shop.getUrl());
        shopDto.setPrice(shop.getPrice());
        shopDto.setPrinterId(shop.getPrinterId());
        shopDto.setCreationDate(shopDto.getCreationDate());
        shopDto.setUpdateDate(shopDto.getUpdateDate());
        return shopDto;
    }

}

