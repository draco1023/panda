package com.yukong.panda.auth.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yukong
 * @date: 2018/10/15 16:56
 * @description:
 */
@RestController
public class TestController {

    @GetMapping("/say")
    public String say() {
        return "index";
    }
}
