package com.example.springstudygraphql.service;

import com.example.springstudygraphql.model.Member;
import com.example.springstudygraphql.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    //getting all members
    public List<Member> getAllMembers() {
        var all = memberRepository.findAll();
        return all;
    }
}
