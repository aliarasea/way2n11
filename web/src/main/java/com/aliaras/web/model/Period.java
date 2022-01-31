package com.aliaras.web.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Period {
    private LocalDateTime start;
    private LocalDateTime end;
    private List<Presentation> presentations;
}
