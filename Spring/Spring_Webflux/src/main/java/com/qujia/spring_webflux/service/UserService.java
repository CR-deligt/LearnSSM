package com.qujia.spring_webflux.service;

import com.qujia.spring_webflux.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//用户操作接口
public interface UserService {
    //通过id查询用户
    Mono<User> getUserById(int id);
    //查询所有用户
    Flux<User> getAllUsers();
    //添加用户
    Mono<Void> saveUserInfo(Mono<User> user);
}
