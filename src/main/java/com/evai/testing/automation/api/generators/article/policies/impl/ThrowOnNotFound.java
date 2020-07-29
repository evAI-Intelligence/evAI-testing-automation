package com.evai.testing.automation.api.generators.article.policies.impl;

import com.evai.testing.automation.api.generators.article.policies.ArticleGeneratorNotFoundPolicy;

public class ThrowOnNotFound implements ArticleGeneratorNotFoundPolicy {
    @Override
    public void OnLayerNotFound(String layerName) {
        throw new IllegalArgumentException(String.format("Layer '%s' has not been found", layerName));
    }
}
