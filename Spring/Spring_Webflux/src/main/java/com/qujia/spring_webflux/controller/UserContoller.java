package com.qujia.spring_webflux.controller;

import com.qujia.spring_webflux.entity.User;
import com.qujia.spring_webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserContoller {
    @Autowired
    UserService userService;
    @GetMapping("/user/{id}")
    public Mono<User> getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
    @GetMapping("/user")
    public Flux<User> getUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/saveuser")
    public Mono<Void> saveUser(@RequestBody User user){
        Mono<User> userMono = Mono.just(user);
        return userService.saveUserInfo(userMono);
    }
}
