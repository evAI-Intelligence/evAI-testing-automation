package com.evai.testing.automation.api.generators.article.policies.impl;

import com.evai.testing.automation.api.generators.article.policies.ArticleGeneratorPropertySeedPolicy;
import org.apache.logging.log4j.util.Strings;

public class StaticPropertyList implements ArticleGeneratorPropertySeedPolicy {

    @Override
    public String getPropertyForIndex(int index) {
        return Strings.EMPTY;
    }
}
