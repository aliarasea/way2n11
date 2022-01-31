package com.aliaras.web.controller;

import com.aliaras.web.constant.PeriodType;
import com.aliaras.web.model.Conference;
import com.aliaras.web.model.Period;
import com.aliaras.web.model.Track;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ConferenceController {

    @Value("${API_URL}")
    private String API_URL;

    private final RestTemplate restTemplate;

    @GetMapping("/conference")
    public String conferenceSchedule(Model model) {
        Conference conference = new Conference();
        conference.setName(String.format("Conference %s", LocalDateTime.now()));
        ResponseEntity<Conference> response =
                restTemplate.postForEntity(API_URL + "/conference/add", conference, Conference.class);
        conference = response.getBody();
        model.addAttribute("conference", conference);
        return "conference";
    }
}
