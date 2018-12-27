/*
 * @Copyright: 2005-2018 www.2345.com. All rights reserved.
 */
package com.spring.demo.service;

import com.spring.demo.dao.UserRepository;
import com.spring.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author chentl
 * @version UserService, v0.1 2018/11/15 16:28
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Mono<User> save(User user){
        return userRepository.save(user).onErrorResume(e->userRepository.findByUsername(user.getUsername()).flatMap(oldUser->{
            user.setId(oldUser.getId());
            return userRepository.save(user);
        }));
    }

    public Mono<Long> deleteByUsername(String username) {
        return userRepository.deleteByUsername(username);
    }

    public Mono<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }
}
