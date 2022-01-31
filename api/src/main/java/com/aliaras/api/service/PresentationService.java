package com.aliaras.api.service;

import com.aliaras.api.entity.Presentation;
import com.aliaras.api.repo.PresentationRepository;
import com.aliaras.api.service.impl.IPresentationService;
import com.aliaras.api.util.PresentationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PresentationService implements IPresentationService {

    private final PresentationRepository presentationRepository;

    @Override
    public List<Presentation> getPresentations() {
        return presentationRepository.findAll();
    }

    @Override
    public Presentation getPresentationByName(String name) {
        return presentationRepository.findByName(name);
    }

    @Override
    public Presentation savePresentation(Presentation presentation) {
        PresentationUtil.setPresentationType(presentation);
        return presentationRepository.insert(presentation);
    }
}
