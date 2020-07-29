package com.evai.testing.automation.api.generators.article.policies;

import com.evai.testing.automation.api.data.model.EntityLayer;
import com.evai.testing.automation.api.data.model.Entity;

import java.util.List;
import java.util.Optional;

public interface ArticleGeneratorSourcePolicy {
    String getLayerId(String name, int user);

    List<String> getTermsByLayerId(String id);

    String getRandomStopWord();
}
