package com.example.springstudygraphql.service;

import com.example.springstudygraphql.model.School;
import com.example.springstudygraphql.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public void saveSchools() {
        schoolRepository.saveAll(List.of(
                School.builder().name("school1").address("address1").build(),
                School.builder().name("school2").address("address2").build()
        ));
    }
}
