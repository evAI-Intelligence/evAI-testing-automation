package com.evai.testing.automation.api.generators.article.policies;

import com.evai.testing.automation.api.data.model.EvAIArticle;

public interface ArticleGeneratorSinkPolicy {
    void flush(EvAIArticle article);
}
