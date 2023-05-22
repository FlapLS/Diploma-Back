package com.example.plasticmodels.service;


import com.example.plasticmodels.domain.Shop;
import com.example.plasticmodels.models.ShopDto;

import java.util.List;

public interface ShopService {
    void createShop(Shop shop);

    void updateShop(ShopDto shopDto, Long id);

    ShopDto getShop(Long id);

    void deleteShop(Long id);

    List<ShopDto> findAllShops();

    void deleteShopByPlasticModelId(Long id);
}
