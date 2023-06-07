package com.springsecurity.security.board.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

}
