package com.aliaras.web.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Conference {
    private String id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<Track> tracks;
}
