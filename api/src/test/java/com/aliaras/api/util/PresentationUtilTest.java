package com.aliaras.api.util;

import com.aliaras.api.constant.PresentationType;
import com.aliaras.api.entity.Presentation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PresentationUtilTest {

    @Mock
    private Presentation presentation;

    @Test
    void setPresentationType() {
        presentation = Presentation.builder().duration(5).build();
        PresentationUtil.setPresentationType(presentation);
        Assertions.assertEquals(PresentationType.LIGHTNING.toString(), presentation.getType());
        presentation = Presentation.builder().duration(15).build();
        PresentationUtil.setPresentationType(presentation);
        Assertions.assertEquals(PresentationType.REGULAR.toString(), presentation.getType());
    }
}