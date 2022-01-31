package com.aliaras.api.restcontroller;

import com.aliaras.api.entity.Conference;
import com.aliaras.api.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/conference")
@RestController
@RequiredArgsConstructor
public class ConferenceRestController {
    private final ConferenceService conferenceService;

    @GetMapping("/get/{name}")
    public ResponseEntity<Conference> getConference(@PathVariable String name) {
        Conference conference = conferenceService.getConferenceByName(name);
        HttpStatus status = conference != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(conference, status);
    }

    @PostMapping("/add")
    public ResponseEntity<Conference> createConference(@RequestBody Conference conference) {
        conference = conferenceService.saveConference(conference);
        return new ResponseEntity<>(conference, HttpStatus.CREATED);
    }

}
