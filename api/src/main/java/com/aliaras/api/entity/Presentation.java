package com.aliaras.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@Builder
@Document(collection = "presentation")
public class Presentation {

    @Id
    private String id;
    private String name;
    private Integer duration;
    private String type;
    private LocalDateTime start;
    private LocalDateTime end;
}
