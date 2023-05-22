package com.example.plasticmodels.utils;

import com.example.plasticmodels.domain.PlasticModels;
import com.example.plasticmodels.domain.Shop;
import com.example.plasticmodels.models.PlasticModelsDto;
import com.example.plasticmodels.models.ShopDto;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {
    public PlasticModelsDto map(PlasticModels plasticModels) {
        PlasticModelsDto plasticModelsDto = new PlasticModelsDto();
        plasticModelsDto.setId(plasticModels.getId());
        plasticModelsDto.setName(plasticModels.getName());
        plasticModelsDto.setType(plasticModels.getType());
        plasticModelsDto.setCompany(plasticModels.getCompany());
        plasticModelsDto.setAmount(plasticModels.getAmount());
        plasticModelsDto.setCreationDate(plasticModels.getCreationDate());
        return plasticModelsDto;
    }
    public ShopDto map(Shop shop) {
        ShopDto shopDto = new ShopDto();
        shopDto.setShopId(shop.getShopId());
        shopDto.setName(shop.getName());
        shopDto.setUrl(shop.getUrl());
        shopDto.setPrice(shop.getPrice());
        shopDto.setPlasticModelId(shopDto.getPlasticModelId());
        shopDto.setCreationDate(shopDto.getCreationDate());
        shopDto.setUpdateDate(shopDto.getUpdateDate());
        return shopDto;
    }
}

