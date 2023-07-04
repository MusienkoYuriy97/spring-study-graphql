package com.example.springstudygraphql.service;

import com.example.springstudygraphql.model.Member;
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
        var member1 = Member.builder().name("member1").address("Maddress1").build();
        var member2 = Member.builder().name("member2").address("Maddress2").build();

        var schoolWMembers = School.builder().name("school1").address("address1").build();
        schoolWMembers.addMember(member1);
        schoolWMembers.addMember(member2);
        schoolRepository.saveAll(List.of(
                schoolWMembers,
                School.builder().name("school2").address("address2").build()
        ));
    }
}
