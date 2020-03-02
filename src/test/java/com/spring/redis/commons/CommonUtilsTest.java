package com.spring.redis.commons;

import com.spring.redis.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class CommonUtilsTest {

    @Test
    void should_filter_users_with_password_not_null() {

    }

}
