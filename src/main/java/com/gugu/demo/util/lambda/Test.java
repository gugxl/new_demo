package com.gugu.demo.util.lambda;


import com.gugu.demo.util.json.gson.User;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Test {
    public static void main(String[] args) {
        // 使用双冒号::来构造静态函数引用
        Function<String, Integer> fun = Integer::parseInt;

        Integer value = fun.apply("123");
        System.out.println(value);

        // 使用双冒号::来构造非静态函数引用
        String content = "Hello JDK8";
        Function<Integer, String> func = content::substring;
        String result = func.apply(1);
        System.out.println(result);

        // 构造函数引用
        BiFunction<String, Integer, User> biFunction = User::new;
        User user = biFunction.apply("mengday", 28);
        System.out.println(user.toString());

        // 函数引用也是一种函数式接口，所以也可以将函数引用作为方法的参数
        sayHello(String::toUpperCase, "hello");
    }

    // 方法有两个参数
    private static void sayHello(Function<String, String> func, String parameter){
        String result = func.apply(parameter);
        System.out.println(result);
    }

}
