package com.example.plasticmodels.service.Imp;


import com.example.plasticmodels.domain.PlasticModels;
import com.example.plasticmodels.domain.PlasticModelsRepository;
import com.example.plasticmodels.models.PlasticModelsDto;
import com.example.plasticmodels.service.PlasticModelService;
import com.example.plasticmodels.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlasticModelServiceImp implements PlasticModelService {

    @Autowired private PlasticModelsRepository plasticModelsRepository;
    @Autowired private ModelMapper modelMapper;

    @Override
    public void createPlasticModel(PlasticModels plasticModels) {
        PlasticModels plasticModels1 = new PlasticModels();
        plasticModels1.setId(plasticModels.getId());
        plasticModels1.setName(plasticModels.getName());
        plasticModels1.setType(plasticModels.getType());
        plasticModels1.setCompany(plasticModels.getCompany());
        plasticModels1.setAmount(plasticModels.getAmount());
        plasticModels1.setCreationDate(LocalDateTime.now());
        plasticModelsRepository.save(plasticModels1);
    }

    @Override
    public void updatePlasticModel(PlasticModelsDto plasticModelsDto,Long id) {
        PlasticModels plasticModels = plasticModelsRepository.findById(id).orElseThrow();
        plasticModels.setName(plasticModelsDto.getName());
        plasticModels.setCompany(plasticModelsDto.getCompany());
        plasticModels.setType(plasticModelsDto.getType());
        plasticModels.setAmount(plasticModelsDto.getAmount());
        plasticModelsRepository.save(plasticModels);
    }

    @Override
    public PlasticModelsDto getPlasticModel(Long id) {
         return modelMapper.map(plasticModelsRepository.findById(id).orElseThrow());
    }

    @Override
    public void deletePlasticModel(Long id) {
        PlasticModels plasticModels = plasticModelsRepository.findById(id).orElseThrow();
        plasticModelsRepository.delete(plasticModels);
    }

    @Override
    public List<PlasticModelsDto> findAllModels() {
        return plasticModelsRepository.findAll()
                .stream()
                .map(modelMapper::map)
                .collect(Collectors.toList());
    }
}
