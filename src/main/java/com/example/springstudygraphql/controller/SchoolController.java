package com.example.springstudygraphql.controller;

import com.example.springstudygraphql.model.Member;
import com.example.springstudygraphql.model.School;
import com.example.springstudygraphql.service.MemberService;
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
    private final MemberService memberService;

    //query mapping for getting a list of schools
    @QueryMapping("schools")
    public List<School> getSchools() {
        var allSchools = schoolService.getAllSchools();
        return allSchools;
    }

    @QueryMapping("members")
    public List<Member> getMembers() {
        var allMembers = memberService.getAllMembers();
        return allMembers;
    }
}
