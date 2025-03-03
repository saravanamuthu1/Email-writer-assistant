package com.email.writer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/test")


@RestController
public class TestController {
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}

