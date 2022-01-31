package com.aliaras.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Way2N11ApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(() -> {
            ApiApplication.main(new String[]{});
        });
    }

}
