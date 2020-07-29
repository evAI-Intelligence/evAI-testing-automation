package com.evai.testing.automation.api.generators.article;

import com.evai.commons.model.EvAIInputClient;
import com.evai.testing.automation.api.data.model.EvAIArticle;
import com.evai.testing.automation.api.generators.article.policies.*;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.*;

@AllArgsConstructor
public class ArticleGenerator {
    private final ArticleGeneratorSourcePolicy source;
    private final ArticleGeneratorTimestampPolicy dateSource;
    private final ArticleGeneratorPropertySeedPolicy properSeeder;
    private final ArticleGeneratorNotFoundPolicy notFound;
    private final ArticleGeneratorThresholds thresholds;

    @NotNull
    @Contract("_, !null, _, _ -> new")
    public EvAIArticle generate(int corpus, String[] layers, int user, int index) {
        List<String> sequence = new LinkedList<>();
        Map<String, TermStats> stats = new HashMap<>();

        while (sequence.size() < corpus) {
            for (var name : layers) {
                var layerId = source.getLayerId(name, user);

                if (layerId == null || layerId.isEmpty()) notFound.OnLayerNotFound(name);

                var words = source.getTermsByLayerId(layerId);
                for (var w : words) {
                    sequence.add(w);
                    if (!stats.containsKey(w)) {
                        stats.put(w, TermStats.builder()
                                .entryCount(0)
                                .layer(layerId)
                                .term(w)
                                .user(user).build());
                    }
                    stats.get(w).entryCount++;

                    var s = sequence.size();
                    var ratio = s / thresholds.termsCountPerStopWord();
                    if (ratio > 0 && ratio * s <= thresholds.stopWordsThreshold()) {
                        var stopWord = source.getRandomStopWord();
                        sequence.add(stopWord);
                        if (!stats.containsKey(stopWord)) {
                            stats.put(stopWord, TermStats.builder()
                                    .entryCount(0)
                                    .layer(layerId)
                                    .term(w)
                                    .user(user).build());
                        }
                        stats.get(stopWord).entryCount++;
                    }
                }
            }
        }

        var contentBuilder = new StringBuilder(sequence.size());
        sequence.forEach(contentBuilder::append);

        return EvAIArticle.builder()
                .requestId(UUID.randomUUID())
                .additionalInformation("Additional info synth #" + index)
                .content(contentBuilder.toString())
                .detectedLanguage("GERMAN")
                .processed(false)
                .publisher("Article Generator")
                .term("term")
                .site("site.com")
                .project("synthart")
                .publicationDate(dateSource.generatePublishDate(index))
                .creationDate(dateSource.generateCreatedDate(index))
                .title("Synthetic Article #" + index)
                .url("site.com/" + index)
                .client(EvAIInputClient.GOOGLE)
                .requestLanguage("de")
                .build();
    }


    private static int meaningfulTermsCount(int corpus, double pureCorpus) {
        return (int) Math.floor(corpus * pureCorpus);
    }
}
