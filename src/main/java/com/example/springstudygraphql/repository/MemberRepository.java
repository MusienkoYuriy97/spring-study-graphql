

package com.example.springstudygraphql.repository;


import com.example.springstudygraphql.model.Member;
import com.example.springstudygraphql.model.Role;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @EntityGraph(value = "Member.school")
    List<Member> findAllByRole(Role role);
}
