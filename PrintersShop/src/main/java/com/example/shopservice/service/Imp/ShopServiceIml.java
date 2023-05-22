package com.example.shopservice.service.Imp;

import com.example.shopservice.domain.*;
import com.example.shopservice.models.ShopDto;
import com.example.shopservice.service.ShopService;
import com.example.shopservice.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopServiceIml implements ShopService {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private PrinterRepository printerRepository;
    @Autowired
    private HistoryPriceRepository historyPriceRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void createShop(Shop shop) {
        Shop shop1 = new Shop();
        shop1.setShopId(shop.getShopId());
        shop1.setName(shop.getName());
        shop1.setUrl(shop.getUrl());
        shop1.setPrice(shop.getPrice());
        shop1.setPrinterId(shop.getPrinterId());
        shop1.setCreationDate(LocalDateTime.now());
        shop1.setUpdateDate((LocalDateTime.now()));
        shopRepository.save(shop1);
        HistoryPrice historyPrice = new HistoryPrice();
        historyPrice.setPrice(shop1.getPrice());
        historyPrice.setShopId(shop1.getShopId());
        historyPrice.setUpdateDate(shop1.getUpdateDate());
        historyPriceRepository.save(historyPrice);
    }

    @Override
    public void updateShop(ShopDto shopDto, Long id) {
        Shop shop = shopRepository.findById(id).orElseThrow(null);
        shop.setPrice(shopDto.getPrice());
        shop.setUpdateDate(LocalDateTime.now());
        shopRepository.save(shop);
        HistoryPrice historyPrice = new HistoryPrice();
        historyPrice.setPrice(shop.getPrice());
        historyPrice.setShopId(shop.getShopId());
        historyPrice.setUpdateDate(shop.getUpdateDate());
        historyPriceRepository.save(historyPrice);
    }

    @Override
    public ShopDto getShop(Long id) {
        return modelMapper.map(shopRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteShop(Long id) {
        Shop shop = shopRepository.findById(id).orElseThrow();
        shopRepository.delete(shop);
    }

    @Override
    public List<ShopDto> findAllShops() {
        return shopRepository.findAll()
                .stream()
                .map(modelMapper::map)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteShopByPrinterId(Long id) {
        List<Shop> shops = shopRepository.findAllByPrinterId(id);
        shopRepository.deleteAll(shops);
    }
}
