package com.springsecurity.security.restcontroller;

import com.springsecurity.security.dto.JwtRequestDto;
import com.springsecurity.security.dto.MemberSignupRequestDto;
import com.springsecurity.security.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String login(@RequestBody JwtRequestDto request) throws Exception {

        return authService.login(request);
    }

    @PostMapping("/signup")
    public String signup(@RequestBody MemberSignupRequestDto request) {

        return authService.signup(request);

    }
}
