package com.example.springstudygraphql.controller;

import com.example.springstudygraphql.model.Member;
import com.example.springstudygraphql.model.Role;
import com.example.springstudygraphql.model.School;
import com.example.springstudygraphql.service.MemberService;
import com.example.springstudygraphql.service.SchoolService;
import graphql.GraphQLContext;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

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

    @QueryMapping("membersByRole")
    public List<Member> getMembersByRole(@Argument Role role,
                                         GraphQLContext context) {
        var allMembersByRole = memberService.getAllMembersByRole(role);
        return allMembersByRole;
    }

    @BatchMapping
    public Callable<Map<Member, Role>> role(List<Member> members,
                                             GraphQLContext context) {
        System.out.println("members = " + members);
        return () -> memberService.getMemberRoles(members);
    }

//    @SchemaMapping(typeName = "Member")
//    public Role role(Member member) {
//        return Role.STAFF;
//    }
//
//    @SchemaMapping(typeName = "School")
//    public String name(School School) {
//        return School.getName();
//    }
}
