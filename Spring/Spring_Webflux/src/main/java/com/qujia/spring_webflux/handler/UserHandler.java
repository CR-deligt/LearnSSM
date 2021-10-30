package com.qujia.spring_webflux.handler;

import com.qujia.spring_webflux.entity.User;
import com.qujia.spring_webflux.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

//public class UserHandler {
//    public final UserService userService;
//    public UserHandler(UserService userService){
//        this.userService=userService;
//    }
//    public Mono<ServerResponse> getUserById(ServerRequest request){
//        String id = request.pathVariable("id");
//        int userId = Integer.valueOf(id);
//        //如果是空值
//        Mono<ServerResponse> noFound = ServerResponse.notFound().build();
//        Mono<User> userMono = this.userService.getUserById(userId);
//        return userMono
//                .flatMap(person->ServerResponse.ok()
//                .contentType(MediaType.APPLICATION_JSON)
//                .body(fromObject(person)))
//                .switchIfEmpty(noFound);
//       // return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(userMono,User.class);
//    }
//
//    public Mono<ServerResponse> getALlUsers(ServerRequest request){
//        Flux<User> users = this.userService.getAllUsers();
//        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users,User.class);
//    }
//
//    public Mono<ServerResponse> saveUser(ServerRequest request){
//        Mono<User> userMono =request.bodyToMono(User.class);
//        return ServerResponse.ok().build(this.userService.saveUserInfo((userMono)));
//    }
//}

public class UserHandler {

    private final UserService userService;
    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    //根据id查询
    public Mono<ServerResponse> getUserById(ServerRequest request) {
        //获取id值
        int userId = Integer.valueOf(request.pathVariable("id"));
        //空值处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();

        //调用service方法得到数据
        Mono<User> userMono = this.userService.getUserById(userId);
        //把userMono进行转换返回
        //使用Reactor操作符flatMap
        return
                userMono
                        .flatMap(person -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                                .body(fromObject(person)))
                        .switchIfEmpty(notFound);
    }

    //查询所有
    public Mono<ServerResponse> getAllUsers(ServerRequest request) {
        //调用service得到结果
        Flux<User> users = this.userService.getAllUsers();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(users,User.class);
    }

    //添加
    public Mono<ServerResponse> saveUser(ServerRequest request) {
        //得到user对象
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().build(this.userService.saveUserInfo(userMono));
    }

}
