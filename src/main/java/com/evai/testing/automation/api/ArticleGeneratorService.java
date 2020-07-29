package com.evai.testing.automation.api;

import com.evai.testing.automation.api.data.model.EvAIArticle;
import com.evai.testing.automation.api.data.model.GeneratorRequestEntry;
import com.evai.testing.automation.api.generators.article.ArticleGenerator;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.Contract;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ArticleGeneratorService {
    private final ArticleGenerator generator;

    @Contract("!null -> new")
    private List<EvAIArticle> batch(List<GeneratorRequestEntry> request) {
        var result = new ArrayList<EvAIArticle>(request.size());

        request.forEach((r) -> result.add(
                generator.generate(r.getCorpus(), r.getLayerNames(), r.getUserId(), request.indexOf(r))));

        return result;
    }
}
