package com.qujia.spring_webflux.service.imp;

import com.qujia.spring_webflux.entity.User;
import com.qujia.spring_webflux.service.UserService;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
@Repository
public class UserServiceImpl implements UserService {
    private final Map<Integer,User> users= new HashMap<>();

    public UserServiceImpl(){
        this.users.put(1,new User("lucy","男","20"));
        this.users.put(2,new User("mary","女","17"));
        this.users.put(3,new User("jack","男","19"));
    }

    @Override
    public Mono<User> getUserById(int id) {
        System.out.println(this.users.get(id));
        return Mono.justOrEmpty(this.users.get(id));
    }

    @Override
    public Flux<User> getAllUsers() {
        return Flux.fromIterable(this.users.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> user) {
        return user.doOnNext(person->{
            int id=users.size()+1;
            users.put(id,person);
        }).thenEmpty(Mono.empty());
    }
}
