package com.evai.testing.automation.api;

import com.evai.testing.automation.api.data.AnnotatorEntityService;
import com.evai.testing.automation.api.data.SourcingArticleService;
import com.evai.testing.automation.api.data.model.GeneratorRequestEntry;
import com.evai.testing.automation.api.generators.article.ArticleGenerator;
import com.evai.testing.automation.api.generators.article.SyntheticArticle;
import com.evai.testing.automation.api.generators.article.policies.impl.*;
import org.jetbrains.annotations.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ArticleGeneratorService {

    private AnnotatorEntityService sourceService;
    private SourcingArticleService sinkService;

    @Contract("null->fail")
    public void setSourceService(AnnotatorEntityService sourceService) {
        Assert.notNull(sourceService, "Source service shall not be null");
        this.sourceService = sourceService;
    }

    private ArticleGenerator generator;

    @Contract("!null -> new")
    public List<SyntheticArticle> batch(List<GeneratorRequestEntry> request) {
        if (generator == null) {
            generator = new ArticleGenerator(
                    new ServiceSource(sourceService),
                    new DeltaFromIndexDate(),
                    new StaticPropertyList(),
                    new ThrowOnNotFound(),
                    new DefaultThresholds()
            );
        }

        var result = new ArrayList<SyntheticArticle>(request.size());

        request.forEach((r) -> result.add(
                generator.generate(r.getCorpus(), r.getLayerNames(), r.getUserId(), request.indexOf(r))));

        return result;
    }
}
