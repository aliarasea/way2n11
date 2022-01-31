package com.aliaras.api.restcontroller;

import com.aliaras.api.entity.Conference;
import com.aliaras.api.service.ConferenceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ConferenceRestControllerTest {

    @Mock
    private ConferenceService conferenceService;

    @Mock
    private Conference conference;

    @InjectMocks
    private ConferenceRestController conferenceRestController;

    @Test
    void getConference() {
        Assertions.assertDoesNotThrow(() -> conferenceRestController.getConference("test"));
    }

    @Test
    void createConference() {
        Assertions.assertDoesNotThrow(() -> conferenceRestController.createConference(conference));
    }
}