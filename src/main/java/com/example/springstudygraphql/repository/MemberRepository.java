

package com.example.springstudygraphql.repository;


import com.example.springstudygraphql.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
