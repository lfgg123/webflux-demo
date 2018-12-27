/*
 * @Copyright: 2005-2018 www.2345.com. All rights reserved.
 */
package com.spring.demo.controller;

import com.spring.demo.model.User;
import com.spring.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author chentl
 * @version UserHandler, v0.1 2018/11/15 16:55
 */
@Component
@EnableWebFlux
public class UserHandler {

    @Autowired
    private UserService userService;

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        Mono<User> reqParam = serverRequest.formData().flatMap(map -> userService.findByUsername(map.getFirst("username")));
        return ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(reqParam,User.class);
    }
}
