package com.aliaras.api.service;

import com.aliaras.api.entity.Conference;
import com.aliaras.api.entity.Presentation;
import com.aliaras.api.entity.Track;
import com.aliaras.api.repo.ConferenceRepository;
import com.aliaras.api.service.impl.IConferenceService;
import com.aliaras.api.util.ConferenceUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConferenceService implements IConferenceService {

    private final ConferenceRepository conferenceRepository;

    private final PresentationService presentationService;

    @Override
    public Conference saveConference(Conference conference) {
        List<Presentation> presentations = presentationService.getPresentations();
        List<Track> tracks = new ArrayList<>();
        ConferenceUtil.assignPresentationToTracks(tracks, presentations);
        conference.setTracks(tracks);
        return conferenceRepository.insert(conference);
    }

    @Override
    public Conference getConferenceByName(String name) {
        return conferenceRepository.findByName(name);
    }
}
