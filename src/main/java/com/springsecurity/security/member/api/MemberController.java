package com.springsecurity.security.member.api;

import com.springsecurity.security.member.request.JwtRequestDto;
import com.springsecurity.security.member.request.MemberSignupRequestDto;
import com.springsecurity.security.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody JwtRequestDto request) throws Exception {

        return memberService.login(request);
    }

    @PostMapping("/signup")
    public String signup(@RequestBody MemberSignupRequestDto request) {

        return memberService.signup(request);

    }

}
