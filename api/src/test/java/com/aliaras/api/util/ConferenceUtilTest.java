package com.aliaras.api.util;

import com.aliaras.api.entity.Presentation;
import com.aliaras.api.entity.Track;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ConferenceUtilTest {

    private List<Track> tracks = new ArrayList<>();

    private List<Presentation> presentations = List.of(
            Presentation
                    .builder()
                    .name("test")
                    .duration(60)
                    .end(LocalDateTime.now())
                    .start(LocalDateTime.now().plusHours(1))
                    .build());

    @Test
    void assignPresentationToTracks() {
        Assertions.assertDoesNotThrow(() -> {
            ConferenceUtil.assignPresentationToTracks(tracks, presentations);
        });
    }
}