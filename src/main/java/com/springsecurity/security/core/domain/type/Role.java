package com.springsecurity.security.core.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {

    USER("유저")
    ;

    private String description;
}
