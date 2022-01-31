package com.aliaras.api.config.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

class ZonedDateTimeWriteConverterTest {

    @Test
    void convert() {
        Assertions.assertDoesNotThrow(() -> new ZonedDateTimeWriteConverter().convert(ZonedDateTime.now()));
    }
}