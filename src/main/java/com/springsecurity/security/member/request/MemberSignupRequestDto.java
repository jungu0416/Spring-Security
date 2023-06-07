package com.springsecurity.security.member.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignupRequestDto {

    private String email;
    private String password;
    private String name;
}
