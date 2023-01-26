package com.springsecurity.security.service;

import com.springsecurity.security.domain.Member;
import com.springsecurity.security.dto.JwtRequestDto;
import com.springsecurity.security.repository.MemberRepository;
import com.springsecurity.security.dto.MemberSignupRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public String signup(MemberSignupRequestDto memberSignupRequestDto) {
        boolean existMember = memberRepository.existsById(memberSignupRequestDto.getEmail());

        if (existMember) return "이미 가입된 회원입니다. ";

        Member member = new Member(memberSignupRequestDto);
        memberRepository.save(member);

        return member.getEmail();

    }

    public String login(JwtRequestDto request) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl principal = (UserDetailsImpl) authentication.getPrincipal();
        return principal.getUsername();

    }
}
