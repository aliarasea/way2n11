package com.aliaras.web.model;

import com.aliaras.web.constant.PeriodType;
import lombok.Data;

import java.util.Map;

@Data
public class Track {
    private String name;
    private Map<PeriodType, Period> periods;
}
