package com.aliaras.api.service;

import com.aliaras.api.entity.Presentation;
import com.aliaras.api.repo.PresentationRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class PresentationServiceTest {

    @Mock
    private Presentation presentation;

    @Mock
    private PresentationRepository presentationRepository;

    @InjectMocks
    private PresentationService presentationService;

    @Test
    void getPresentations() {
        Mockito.when(presentationService.getPresentations()).thenReturn(List.of(presentation));
        Assertions.assertNotNull(presentationService.getPresentations());
    }

    @Test
    void getPresentationByName() {
        Mockito.when(presentationService.getPresentationByName("")).thenReturn(presentation);
        Assertions.assertNotNull(presentationService.getPresentationByName(""));
    }

    @Test
    void addPresentation() {
        Mockito.when(presentationRepository.insert(presentation)).thenReturn(presentation);
        Assertions.assertNotNull(presentationService.savePresentation(presentation));
    }
}