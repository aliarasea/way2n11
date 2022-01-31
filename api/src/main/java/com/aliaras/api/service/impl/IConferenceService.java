package com.aliaras.api.service.impl;

import com.aliaras.api.entity.Conference;

public interface IConferenceService {
    Conference getConferenceByName(String name);
    Conference saveConference(Conference conference);
}
