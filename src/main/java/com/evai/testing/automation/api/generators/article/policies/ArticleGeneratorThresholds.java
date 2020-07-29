package com.evai.testing.automation.api.generators.article.policies;

public interface ArticleGeneratorThresholds {

    default int stopWordsThreshold() {
        return 3;
    }

    default int termsCountPerStopWord() {
        return 10;
    }

    int randomStopWordCount();

    default int propertyThreshold() {
        return 9;
    }

    default int termsCountPerProperty() {
        return 50;
    }

    int randomPropertyCount();
}
