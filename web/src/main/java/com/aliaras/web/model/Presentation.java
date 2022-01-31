package com.aliaras.web.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Presentation {
    private String id;
    private String name;
    private Integer duration;
    private String type;
    private LocalDateTime start;
}
