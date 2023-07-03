package com.example.springstudygraphql.controller;

import com.example.springstudygraphql.model.School;
import com.example.springstudygraphql.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

//graphql controller
@Controller
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    //query mapping for getting a list of schools
    @QueryMapping("schools")
    public List<School> getSchools() {
        return schoolService.getAllSchools();
    }
}
