package com.evai.testing.automation.api.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "AnnotatorEntity")
public class Entity {

    @Id
    private String id;
    private String content;
    private String layer;
    private String type;
    private Integer user;
    private String language;
}
