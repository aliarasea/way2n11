package com.aliaras.api.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "conference")
public class Conference {
    @Id
    private String id;
    private String name;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<Track> tracks;
}
