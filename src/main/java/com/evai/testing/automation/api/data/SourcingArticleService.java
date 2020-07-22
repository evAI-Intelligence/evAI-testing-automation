package com.evai.testing.automation.api.data;

import com.evai.testing.automation.api.data.model.EvAIArticle;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SourcingArticleService {

    private MongoTemplate template;

    /**
     * Saves list of articles in "articles" collection.
     * @param articles articles to save.
     */
    public void save(List<EvAIArticle> articles) {
        template.insert(articles, "articles");
    }

}
