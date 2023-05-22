package com.example.shopservice.domain;

import com.example.shopservice.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:9000")
@RepositoryRestResource(collectionResourceRel = "printers", path = "printers")
public interface PrinterRepository extends JpaRepository<Printer, Long>, PagingAndSortingRepository<Printer, Long> {

    List<Printer> findAllByCompany(@Param("company") Company company);

    List<Printer> findAllByAmountBetween(@Param("lower") Integer lower, @Param("higher") Integer higher);



}
