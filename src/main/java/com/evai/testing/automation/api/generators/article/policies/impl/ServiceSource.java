package com.evai.testing.automation.api.generators.article.policies.impl;

import com.evai.testing.automation.api.data.AnnotatorEntityService;
import com.evai.testing.automation.api.data.model.Entity;
import com.evai.testing.automation.api.data.model.EntityLayer;
import com.evai.testing.automation.api.generators.article.policies.ArticleGeneratorSourcePolicy;
import org.apache.logging.log4j.util.Strings;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ServiceSource implements ArticleGeneratorSourcePolicy {

    private final List<EntityLayer> layers;
    private final List<Entity> entities;
    private final Random rng = new Random();

    public ServiceSource(AnnotatorEntityService service) {
        this.layers = service.getLayers();
        this.entities = service.getEntities();
    }

    @Override
    public String getLayerId(final String name, int user) {
        var selection = layers.stream()
                .filter((l) -> l.getName().equals(name) && l.getUser() == user)
                .collect(Collectors.toList());

        if (selection.isEmpty())
            return Strings.EMPTY;

        return selection.get(0).getId();
    }

    @Override
    public List<String> getTermsByLayerId(final String id) {
        return entities.stream()
                .filter((e) -> e.getLayer().equals(id))
                .map(Entity::getContent)
                .collect(Collectors.toUnmodifiableList());
    }

    /**
     * TODO: substitute with real Mongo-fed sourcing;
     */
    @Override
    public String getRandomStopWord() {
        final String[] stopWords = {
                "Die",
                "Dabei",
                "wahrscheinlich",
        };

        var index = rng.nextInt(stopWords.length);
        return stopWords[index];
    }
}
