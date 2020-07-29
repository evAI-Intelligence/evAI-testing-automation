package com.evai.testing.automation.api.data.model;

import lombok.Data;

@Data
public class GeneratorRequestEntry {

    private final String[] layerNames;
    private final int corpus;
    private int userId;
}
