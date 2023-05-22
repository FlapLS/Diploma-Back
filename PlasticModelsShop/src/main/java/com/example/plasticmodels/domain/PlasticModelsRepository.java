package com.example.plasticmodels.domain;

import com.example.plasticmodels.domain.PlasticModels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlasticModelsRepository extends JpaRepository<PlasticModels,Long> {


}
