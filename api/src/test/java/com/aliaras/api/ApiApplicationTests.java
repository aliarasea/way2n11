package com.aliaras.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> {
            ApiApplication.main(new String[]{});
        });
    }

}
