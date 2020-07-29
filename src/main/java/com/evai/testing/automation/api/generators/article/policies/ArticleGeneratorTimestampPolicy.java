package com.evai.testing.automation.api.generators.article.policies;

import java.util.Date;

public interface ArticleGeneratorTimestampPolicy {

    Date generatePublishDate(int index);
    Date generateCreatedDate(int index);

}
