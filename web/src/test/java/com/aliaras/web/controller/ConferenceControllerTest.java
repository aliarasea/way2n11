package com.aliaras.web.controller;

import com.aliaras.web.model.Conference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class ConferenceControllerTest {

    @Mock
    private TestRestTemplate restTemplate;

    @Mock
    private Conference conference;

    @Mock
    private ResponseEntity<Conference> response = new ResponseEntity<>(conference, HttpStatus.CREATED);

    @InjectMocks
    private ConferenceController conferenceController;

    @Test
    void createConference() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            conferenceController.createConference(null);
        });
    }
}