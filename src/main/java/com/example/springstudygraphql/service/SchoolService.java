package com.example.springstudygraphql.service;

import com.example.springstudygraphql.model.Document;
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
        var document1 = Document.builder().name("doc1").documentNumber("docNumber1").build();
        var document2 = Document.builder().name("doc2").documentNumber("docNumber2").build();

        var member1 = Member.builder().name("member1").address("Maddress1").build();
        member1.addDocument(document1);
        member1.addDocument(document2);

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
