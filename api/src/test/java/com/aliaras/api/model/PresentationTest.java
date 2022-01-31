package com.aliaras.api.model;

import com.aliaras.api.entity.Presentation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class PresentationTest {

    @Mock
    private Presentation presentation;

    private static String id;

    @BeforeAll
    static void init() {
        id = UUID.randomUUID().toString();
        System.out.println(id);
    }

    @BeforeEach
    void setUp() {
        presentation = Presentation.builder()
                .id(id)
                .name("test")
                .duration(10)
                .start(LocalDateTime.now())
                .build();
    }

    @Test
    void getName() {
        Assertions.assertSame("test", presentation.getName());
    }

    @Test
    void getDuration() {
        Assertions.assertSame(10, presentation.getDuration());
    }

    @Test
    void setName() {
        Assertions.assertDoesNotThrow(() -> presentation.setName("test2"));
    }

    @Test
    void setDuration() {
        Assertions.assertDoesNotThrow(() -> presentation.setDuration(20));
    }
}