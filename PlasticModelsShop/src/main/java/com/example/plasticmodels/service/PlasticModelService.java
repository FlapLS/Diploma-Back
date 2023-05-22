package com.example.plasticmodels.service;

import com.example.plasticmodels.domain.PlasticModels;
import com.example.plasticmodels.models.PlasticModelsDto;

import java.util.List;


public interface PlasticModelService {
    void createPlasticModel(PlasticModels plasticModels);

    void updatePlasticModel(PlasticModelsDto plasticModelsDto, Long id);

    PlasticModelsDto getPlasticModel(Long id);

    void deletePlasticModel(Long id);

    List<PlasticModelsDto> findAllModels();
}
