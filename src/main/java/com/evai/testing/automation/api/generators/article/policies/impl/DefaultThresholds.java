package com.evai.testing.automation.api.generators.article.policies.impl;

import com.evai.testing.automation.api.generators.article.policies.ArticleGeneratorThresholds;

import java.util.Random;

public class DefaultThresholds implements ArticleGeneratorThresholds {

    private final Random rng = new Random();

    @Override
    public int randomStopWordCount() {
        return rng.nextInt(this.stopWordsThreshold()) + this.termsCountPerStopWord();
    }

    @Override
    public int randomPropertyCount() {
        return rng.nextInt(this.propertyThreshold()) + this.termsCountPerProperty();
    }
}
