package com.evai.testing.automation.api.generators.article;

import com.evai.testing.automation.api.data.model.EvAIArticle;
import com.evai.testing.automation.api.data.model.GeneratorRequestEntry;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SyntheticArticle {
    private final GeneratorRequestEntry traits;
    private final EvAIArticle article;
}
