package com.evai.testing.automation.api.data.model;

import com.evai.commons.model.EvAIInputClient;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

@Document(collection = "articles")
@Data
@Builder
public class EvAIArticle {

    @Id
    public String id;

    private UUID requestId;

    private String term;
    private String project;

    private String url;

    @Indexed(unique = true)
    private String title;

    private String content;
    private String publisher;
    private String site;
    private String additionalInformation;
    private EvAIInputClient client;

    private Date creationDate;
    private Date publicationDate;

    private double weight;

    private String requestLanguage;
    @Setter
    private String detectedLanguage;

    private boolean processed;
    private Date processingDate;

}
