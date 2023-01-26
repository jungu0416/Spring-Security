package com.springsecurity.security.service;

import com.springsecurity.security.domain.Member;
import com.springsecurity.security.repository.MemberRepository;
import com.springsecurity.security.dto.MemberSignupRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public String signup(MemberSignupRequestDto memberSignupRequestDto) {
        boolean existMember = memberRepository.existsById(memberSignupRequestDto.getEmail());

        if (existMember) return null;

        Member member = new Member(memberSignupRequestDto);
        memberRepository.save(member);

        return member.getEmail();

    }
}
