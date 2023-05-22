package com.example.plasticmodels.domain;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@RepositoryRestResource(collectionResourceRel = "shops",path = "shops")
public interface ShopRepository extends JpaRepository<Shop,Long>{

    List<Shop> findAllByPlasticModelId(@Param("plasticModelId" )Long plasticModelId);


}
