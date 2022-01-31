package com.aliaras.api.entity;

import com.aliaras.api.constant.PeriodType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
@Builder
public class Track {
    private String name;
    private Map<PeriodType, Period> periods;
}
