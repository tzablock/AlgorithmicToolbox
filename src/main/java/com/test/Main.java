package com.test;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        Double agv = Stream.of(1,2,3,4).collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(agv);
        System.out.println(Stream.of("a","b","c").collect(Collectors.joining(" and ","Start "," Stop")));
        IntStream.of(1,2,3,4).boxed().map(Integer::getClass).forEach(System.out::println);

    }
}
