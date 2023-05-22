package com.example.plasticmodels.controllers;


import com.example.plasticmodels.common.Endpoints;
import com.example.plasticmodels.common.Logger;
import com.example.plasticmodels.domain.PlasticModels;
import com.example.plasticmodels.models.PlasticModelsDto;
import com.example.plasticmodels.service.PlasticModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class PrinterController {

    @Autowired private PlasticModelService plasticModelService;
    @Autowired private Logger logger;

    @PostMapping(Endpoints.BasicOperationPrinter.PLASTIC_MODEL_CREATE)
    public ResponseEntity<Object> createPlasticModel(@RequestBody PlasticModels plasticModels){
        logger.info("createPlasticModel",plasticModels);
        plasticModelService.createPlasticModel(plasticModels);
        return ResponseEntity.ok().build();
    }
    @GetMapping(Endpoints.BasicOperationPrinter.PLASTIC_MODEL_GET)
    public ResponseEntity<PlasticModelsDto> getPlasticModel(@PathVariable Long plasticModelId){
        logger.info("getPlasticModel",plasticModelId);
        return ResponseEntity.ok(plasticModelService.getPlasticModel(plasticModelId));
    }
    @DeleteMapping(Endpoints.BasicOperationPrinter.PLASTIC_MODEL_DELETE)
    public ResponseEntity<PlasticModelsDto> deletePlasticModel(@PathVariable Long plasticModelId){
        logger.info("deletePrinter",plasticModelId);
        plasticModelService.deletePlasticModel(plasticModelId);
        return ResponseEntity.ok().build();
    }
    @PutMapping(Endpoints.BasicOperationPrinter.PLASTIC_MODEL_UPDATE)
    public ResponseEntity<Object> updatePlasticModel(@RequestBody PlasticModelsDto plasticModelsDto,@PathVariable Long plasticModelId){
        logger.info("updatePlasticModel",plasticModelsDto);
        plasticModelService.updatePlasticModel(plasticModelsDto,plasticModelId);
        return ResponseEntity.ok().build();
    }
    @GetMapping(Endpoints.BasicOperationPrinter.PLASTIC_MODEL_ALL)
    public ResponseEntity<List<PlasticModelsDto>> getAllPlasticModels() {
        logger.info("getAllPrinters","");
        return ResponseEntity.ok(plasticModelService.findAllModels());
    }
}
