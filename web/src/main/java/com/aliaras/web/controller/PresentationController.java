package com.aliaras.web.controller;

import com.aliaras.web.model.Presentation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor
public class PresentationController {

    @Value("${API_URL}")
    private String API_URL;

    private final RestTemplate restTemplate;

    @GetMapping("/presentation")
    public String presentationForm(Model model) {
        model.addAttribute("presentation", new Presentation());
        return "presentation";
    }

    @PostMapping("/presentation")
    public String presentationForm(@ModelAttribute Presentation presentation, Model model) {
        try {
            if (StringUtils.hasText(presentation.getName()) && presentation.getDuration() > 0) {
                ResponseEntity<Presentation> response =
                        restTemplate.postForEntity(API_URL + "/presentation/add", presentation, Presentation.class);

                return response.getStatusCode().is2xxSuccessful() ? presentationForm(model) : "error";
            }
        } catch (Exception e) {
            return "error";
        }
        return presentationForm(model);
    }
}
