package com.evai.testing.automation.api.generators.article;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TermStats {
    public String term;
    public String layer;
    public int user;
    public int entryCount;
    public TermType termType;
}
