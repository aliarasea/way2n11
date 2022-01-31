package com.aliaras.api.util;

import com.aliaras.api.constant.PresentationType;
import com.aliaras.api.entity.Period;
import com.aliaras.api.entity.Presentation;
import com.aliaras.api.entity.Track;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ConferenceUtilTest {

    @Mock
    private Period period;

    private List<Track> tracks = new ArrayList<>();

    private List<Presentation> presentations = List.of(
            Presentation
                    .builder()
                    .name("test")
                    .type(PresentationType.REGULAR.name())
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