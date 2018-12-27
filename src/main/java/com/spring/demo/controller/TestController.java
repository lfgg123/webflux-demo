/*
 * @Copyright: 2005-2018 www.2345.com. All rights reserved.
 */
package com.spring.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author chentl
 * @version TestController, v0.1 2018/10/31 15:23
 */
@RestController
public class TestController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Welcome to reactive world ~");
    }
}
