package com.aliaras.api.service;

import com.aliaras.api.entity.Conference;
import com.aliaras.api.repo.ConferenceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
class ConferenceServiceTest {

    @Mock
    private Conference conference;

    @Mock
    private ConferenceRepository conferenceRepository;

    @Mock
    private PresentationService presentationService;

    @InjectMocks
    private ConferenceService conferenceService;

    @Test
    void getConferenceByName() {
        Assertions.assertDoesNotThrow(() -> {
            conferenceService.getConferenceByName("test");
        });
    }

    @Test
    void saveConference() {
        Assertions.assertDoesNotThrow(() -> {
            Mockito.when(presentationService.getPresentations()).thenReturn(new ArrayList<>());
            conferenceService.saveConference(conference);
        });
    }
}