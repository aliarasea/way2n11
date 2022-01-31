package com.aliaras.web.controller;

import com.aliaras.web.model.Presentation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.ui.ExtendedModelMap;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class PresentationControllerTest {

    @Mock
    private TestRestTemplate restTemplate;

    @Mock
    private ExtendedModelMap model;

    @Mock
    private Presentation presentation;

    @InjectMocks
    private PresentationController presentationController;

    @Test
    void getPresentationTest() {
        Mockito.when(model.addAttribute(any(), any())).thenReturn(model);
        Assertions.assertDoesNotThrow(() -> presentationController.getPresentation(model));
    }

    @Test
    void addPresentationTest() {
        Assertions.assertDoesNotThrow(() -> {
            presentationController.addPresentation(presentation, model);
        });
    }
}