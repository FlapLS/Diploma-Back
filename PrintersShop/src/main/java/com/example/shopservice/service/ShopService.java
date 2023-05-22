package com.example.shopservice.service;

import com.example.shopservice.domain.Printer;
import com.example.shopservice.domain.Shop;
import com.example.shopservice.models.PrinterDto;
import com.example.shopservice.models.ShopDto;

import java.util.List;

public interface ShopService {
    void createShop(Shop shop);

    void updateShop(ShopDto shopDto, Long id);

    ShopDto getShop(Long id);

    void deleteShop(Long id);

    List<ShopDto> findAllShops();

    void deleteShopByPrinterId(Long id);
}
