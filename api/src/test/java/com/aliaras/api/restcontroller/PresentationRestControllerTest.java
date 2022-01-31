package com.aliaras.api.restcontroller;

import com.aliaras.api.entity.Presentation;
import com.aliaras.api.service.PresentationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class PresentationRestControllerTest {

    @Mock
    private Presentation presentation;

    @Mock
    private PresentationService presentationService;

    @InjectMocks
    private PresentationRestController presentationRestController;

    @BeforeEach
    void setup() {
        presentation = Presentation.builder()
                .id(UUID.randomUUID().toString())
                .name("tst")
                .duration(Instant.now().getNano()).build();
    }


    @Test
    void getPresentations() {
        Mockito.when(presentationService.getPresentations()).thenReturn(List.of(presentation));
        Assertions.assertEquals(HttpStatus.OK, presentationRestController.getPresentations().getStatusCode());
        Mockito.when(presentationService.getPresentations()).thenReturn(null);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, presentationRestController.getPresentations().getStatusCode());
    }

    @Test
    void getPresentation() {
        Assertions.assertDoesNotThrow(() -> presentationRestController.getPresentation(presentation.getName()));
    }

    @Test
    void createPresentation() {
        Assertions.assertEquals(HttpStatus.CREATED, presentationRestController.createPresentation(presentation).getStatusCode());
    }
}