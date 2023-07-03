package com.example.springstudygraphql.repository;


import com.example.springstudygraphql.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, Long> {
}
