package com.xiaojun;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class DemoController {

    @GetMapping("/get")
    public String test(HttpServletRequest request) {
        log.info("{}---{}", request.getHeader("username"), request.getHeader("origin"));
        return "hhhhhhhhhhhhhhhhh";
    }
}
