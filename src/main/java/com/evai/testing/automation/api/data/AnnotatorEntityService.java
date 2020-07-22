package com.evai.testing.automation.api.data;

import com.evai.testing.automation.api.data.model.Entity;
import com.evai.testing.automation.api.data.model.EntityLayer;
import com.evai.testing.automation.api.data.model.EntityType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnnotatorEntityService {

    private MongoTemplate template;

    /**
     * Returns all layers(id, name, user) from "AnnotatorLayer" collection.
     */
    public List<EntityLayer> getLayers() {
        return template.findAll(EntityLayer.class, "AnnotatorLayer");
    }

    /**
     * Returns all types(id, name) from "AnnotatorTypeEntity" collection.
     */
    public List<EntityType> getTypes() {
        return template.findAll(EntityType.class, "AnnotatorTypeEntity");
    }

    /**
     * Returns all entities from "AnnotatorEntity" collection.
     */
    public List<Entity> getEntities() {
        return template.findAll(Entity.class, "AnnotatorEntity");
    }

}
