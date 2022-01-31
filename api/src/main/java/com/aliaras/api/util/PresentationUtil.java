package com.aliaras.api.util;

import com.aliaras.api.constant.PresentationType;
import com.aliaras.api.entity.Presentation;

public final class PresentationUtil {
    public static void setPresentationType(Presentation presentation) {
        int duration = presentation.getDuration();
        if (duration == 5) {
            presentation.setType(PresentationType.LIGHTNING.toString());
        } else {
            presentation.setType(PresentationType.REGULAR.toString());
        }
    }
}
