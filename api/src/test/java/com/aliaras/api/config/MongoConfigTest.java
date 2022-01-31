package com.aliaras.api.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MongoConfigTest {

    @Mock
    private MongoConfig mongoConfig;

    @Test
    void getDatabaseName() {
        Mockito.when(mongoConfig.getDatabaseName()).thenReturn("test");
        Assertions.assertSame(String.class, mongoConfig.getDatabaseName().getClass());
    }

    @Test
    void customConversions() {
        Assertions.assertDoesNotThrow(() -> mongoConfig.customConversions());
    }
}