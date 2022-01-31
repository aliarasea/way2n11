package com.aliaras.api.config.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;

class ZonedDateTimeReadConverterTest {

    @Test
    void convert() {
        Assertions.assertDoesNotThrow(() -> new ZonedDateTimeReadConverter().convert(Date.from(Instant.now())));
    }
}
