package com.aliaras.api.config.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ZonedDateTimeWriteConverterTest {

    @Test
    void convert() {
        Assertions.assertDoesNotThrow(() -> new ZonedDateTimeWriteConverter().convert(ZonedDateTime.now()));
    }
}