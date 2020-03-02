package com.spring.redis.main;

import com.spring.redis.domain.User;
import com.spring.redis.interfaces.UserPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Test {

    public static void main(String[] args) {

        List<User> users = Arrays.asList(
                new User(1L, "roberta.grillo", "*****"),
                new User(2L, "robson.grillo", ""),
                new User(3L, "rosana.grillo", "*****")
        );


        System.out.println(filter(users, new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return  user.getPassword().isEmpty();
            }
        }));

       UserPredicate userPredicate = (User user) -> user.getPassword().equals("");

        System.out.println(userPredicate.test(new User(1L, "roberta.grillo", "*****")));
    }


    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T e: list) {
            if(predicate.test(e))
                result.add(e);
        }
        return result;
    }
}
