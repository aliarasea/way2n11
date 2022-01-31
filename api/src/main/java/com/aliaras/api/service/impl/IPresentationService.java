package com.aliaras.api.service.impl;

import com.aliaras.api.entity.Presentation;

import java.util.List;

public interface IPresentationService {
    List<Presentation> getPresentations();
    Presentation getPresentationByName(String name);
    Presentation savePresentation(Presentation presentation);
}
