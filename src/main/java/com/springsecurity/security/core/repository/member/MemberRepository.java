package com.springsecurity.security.core.repository.member;

import com.springsecurity.security.core.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    boolean existsById(String email);
}
