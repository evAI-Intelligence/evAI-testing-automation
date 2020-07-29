package com.evai.testing.automation.api.generators.article.policies.impl;

import com.evai.testing.automation.api.data.SourcingArticleService;
import com.evai.testing.automation.api.data.model.EvAIArticle;
import com.evai.testing.automation.api.generators.article.policies.ArticleGeneratorSinkPolicy;
import com.google.common.collect.Lists;

public class MongoSink implements ArticleGeneratorSinkPolicy {

    private final SourcingArticleService service;

    public MongoSink(SourcingArticleService service) {
        this.service = service;
    }

    @Override
    public void flush(EvAIArticle article) {
        service.save(Lists.asList(article, null));
    }
}
