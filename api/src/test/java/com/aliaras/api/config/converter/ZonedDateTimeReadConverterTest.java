package com.aliaras.api.config.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ZonedDateTimeReadConverterTest {

    @Test
    void convert() {
        Assertions.assertDoesNotThrow(() -> new ZonedDateTimeReadConverter().convert(Date.from(Instant.now())));
    }
}
