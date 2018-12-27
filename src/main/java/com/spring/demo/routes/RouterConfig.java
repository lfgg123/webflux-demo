/*
 * @Copyright: 2005-2018 www.2345.com. All rights reserved.
 */
package com.spring.demo.routes;

import com.spring.demo.controller.TimeHandler;
import com.spring.demo.controller.UserHandler;
import com.spring.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author chentl
 * @version RouterConfig, v0.1 2018/10/31 15:48
 */
@Configuration
@EnableWebFlux
public class RouterConfig {
    @Autowired
    private TimeHandler timeHandler;

    @Autowired
    private UserHandler userHandler;

    @Bean
    public RouterFunction<ServerResponse> timerRouter() {
        return route(GET("/time"), timeHandler::getTime)
                .andRoute(GET("/date"), timeHandler::getDate)
                .andRoute(GET("/times"), timeHandler::sendTimePerSec)
                ;
    }

    @Bean
    public RouterFunction<ServerResponse> userRouter(){
        return route(RequestPredicates.POST("/user/find").and(RequestPredicates.accept(MediaType.APPLICATION_FORM_URLENCODED)),userHandler::save);
    }
}
