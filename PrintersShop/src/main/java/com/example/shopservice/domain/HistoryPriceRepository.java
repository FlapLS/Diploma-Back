package com.example.shopservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@RepositoryRestResource(collectionResourceRel = "history", path = "history")
public interface HistoryPriceRepository extends JpaRepository<HistoryPrice,Long>, PagingAndSortingRepository<HistoryPrice, Long> {
    List<HistoryPrice> findAllByShopId(@Param("shopId")Long shopId);
}
