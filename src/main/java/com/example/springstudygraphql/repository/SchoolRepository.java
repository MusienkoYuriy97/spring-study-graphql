package com.example.springstudygraphql.repository;


import com.example.springstudygraphql.model.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {
    @Query(value = "select s from School s join fetch s.members")
    List<School> findAll();
}
