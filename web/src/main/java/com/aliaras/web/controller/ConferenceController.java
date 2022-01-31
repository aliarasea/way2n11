package com.aliaras.web.controller;

import com.aliaras.web.model.Conference;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class ConferenceController {

    @Value("${API_URL}")
    private String API_URL;

    private final RestTemplate restTemplate;

    @GetMapping("/conference")
    public String createConference(Model model) {
        Conference conference = new Conference();
        conference.setName(String.format("Conference %s", LocalDateTime.now()));
        ResponseEntity<Conference> response =
                restTemplate.postForEntity(API_URL + "/conference/add", conference, Conference.class);
        conference = response.getBody();
        model.addAttribute("conference", conference);
        return "conference";
    }
}
