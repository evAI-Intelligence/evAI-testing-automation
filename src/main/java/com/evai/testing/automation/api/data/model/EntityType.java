package com.evai.testing.automation.api.data.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class EntityType {

    @Id
    private String id;
    private String name;

}
