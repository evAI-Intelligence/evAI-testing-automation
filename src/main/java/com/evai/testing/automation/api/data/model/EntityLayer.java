package com.evai.testing.automation.api.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "AnnotatorLayer")
public class EntityLayer {

    @Id
    private String id;
    private String name;
    private Integer user;
}
