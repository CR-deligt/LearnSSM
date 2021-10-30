package com.qujia.spring_webflux.reactor8;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestReactor {
    public static void main(String[] args) {
        //just直接生成数据流
        Flux.just(1,2,3,4).subscribe(System.out::println);//订阅后才会触发数据流
        Mono.just(1).subscribe(System.out::print);

        //其他方法
//        Integer[] array={1,2,3,4};
//        Flux.fromArray(array);
//
//        List<Integer> list = Arrays.asList(array);
//        Flux.fromIterable(list);
//
//        Stream<Integer> stream = list.stream();
//        Flux.fromStream(stream);

    }
}
