package com.springsecurity.security.repository;

import com.springsecurity.security.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsById(String email);
}
