/*
 * @Copyright: 2005-2018 www.2345.com. All rights reserved.
 */
package com.spring.demo.dao;

import com.spring.demo.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author chentl
 * @version UserRepository, v0.1 2018/11/15 16:23
 */
public interface UserRepository extends ReactiveCrudRepository<User,String> {
    Mono<User> findByUsername(String username);
    Mono<Long> deleteByUsername(String username);
}
