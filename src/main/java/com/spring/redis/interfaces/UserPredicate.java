package com.spring.redis.interfaces;

import com.spring.redis.domain.User;

public interface UserPredicate {
    boolean test(User user);
}
