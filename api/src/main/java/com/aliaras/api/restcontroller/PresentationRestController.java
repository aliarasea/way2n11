package com.aliaras.api.restcontroller;

import com.aliaras.api.entity.Presentation;
import com.aliaras.api.service.PresentationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/presentation")
@RestController
@RequiredArgsConstructor
public class PresentationRestController {

    private final PresentationService presentationService;

    @GetMapping("/get")
    public ResponseEntity<List<Presentation>> getPresentations() {
        List<Presentation> presentationFlux = presentationService.getPresentations();
        HttpStatus status = presentationFlux != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(presentationFlux, status);
    }

    @GetMapping("/get/{name}")
    public ResponseEntity<Presentation> getPresentation(@PathVariable String name) {
        Presentation presentation = presentationService.getPresentationByName(name);
        HttpStatus status = presentation != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(presentation, status);
    }

    @PostMapping("/add")
    public ResponseEntity<Presentation> createPresentation(@RequestBody Presentation presentation) {
        presentation = presentationService.savePresentation(presentation);
        return new ResponseEntity<>(presentation, HttpStatus.CREATED);
    }
}
