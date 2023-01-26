package com.springsecurity.security.restcontroller;

import com.springsecurity.security.dto.JwtRequestDto;
import com.springsecurity.security.dto.MemberSignupRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody JwtRequestDto request){
        return "login";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody MemberSignupRequestDto request){
        return "sign up";
    }
}
