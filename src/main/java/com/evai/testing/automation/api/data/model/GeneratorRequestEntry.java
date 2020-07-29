package com.evai.testing.automation.api.data.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeneratorRequestEntry {

    private final String[] layerNames;
    private final int corpus;
    private int userId;
}
