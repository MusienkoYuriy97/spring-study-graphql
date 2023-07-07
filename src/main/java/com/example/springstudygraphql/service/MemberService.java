package com.example.springstudygraphql.service;

import com.example.springstudygraphql.model.Member;
import com.example.springstudygraphql.model.Role;
import com.example.springstudygraphql.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    //getting all members
    public List<Member> getAllMembers() {
        var all = memberRepository.findAll();
        return all;
    }

    public List<Member> getAllMembersByRole(Role role) {
        var all = memberRepository.findAllByRole(role);
        return all;
    }

    public Map<Member, Role> getMemberRoles(List<Member> members) {
        return members.stream()
                .collect(Collectors.toUnmodifiableMap(
                        Function.identity(),
                        Member::getRole
                ));
    }
}
