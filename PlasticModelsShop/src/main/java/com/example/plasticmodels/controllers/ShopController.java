package com.example.plasticmodels.controllers;


import com.example.plasticmodels.common.Endpoints;
import com.example.plasticmodels.common.Logger;
import com.example.plasticmodels.domain.Shop;
import com.example.plasticmodels.models.ShopDto;
import com.example.plasticmodels.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShopController {
    @Autowired
    private ShopService shopService;

    @Autowired
    private Logger logger;

    @PostMapping(Endpoints.BasicOperationShop.SHOP_CREATE)
    public ResponseEntity<Object> createShop(@RequestBody Shop shop) {
        logger.info("createPrinter", shop);
        shopService.createShop(shop);
        return ResponseEntity.ok().build();
    }

    @GetMapping(Endpoints.BasicOperationShop.SHOP_GET)
    public ResponseEntity<ShopDto> getShop(@PathVariable Long shopsId) {
        logger.info("getPrinter", shopsId);
        return ResponseEntity.ok(shopService.getShop(shopsId));
    }

    @DeleteMapping(Endpoints.BasicOperationShop.SHOP_DELETE)
    public ResponseEntity<ShopDto> deleteShop(@PathVariable Long shopsId) {
        logger.info("deletePrinter", shopsId);
        shopService.deleteShop(shopsId);
        return ResponseEntity.ok().build();
    }

    @PutMapping(Endpoints.BasicOperationShop.SHOP_UPDATE)
    public ResponseEntity<Object> updateShop(@RequestBody ShopDto shopDto, @PathVariable Long shopsId) {
        logger.info("updatePrinter", shopsId);
        shopService.updateShop(shopDto,shopsId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(Endpoints.BasicOperationShop.SHOP_ALL)
    public ResponseEntity<List<ShopDto>> getAllShops() {
        logger.info("getAllPrinters","");
        return ResponseEntity.ok(shopService.findAllShops());
    }
    @DeleteMapping(Endpoints.BasicOperationShop.DELETE_BY_PLASTIC_MODEL_ID)
    public ResponseEntity<List<Shop>> deleteShopByPlasticModelId(@PathVariable Long plasticModelId) {
        logger.info("deletePrinter", plasticModelId);
        shopService.deleteShopByPlasticModelId(plasticModelId);
        return ResponseEntity.ok().build();
    }
}
