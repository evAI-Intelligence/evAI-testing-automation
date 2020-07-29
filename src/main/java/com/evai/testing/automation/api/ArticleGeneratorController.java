package com.evai.testing.automation.api;

import com.evai.testing.automation.api.data.AnnotatorEntityService;
import com.evai.testing.automation.api.data.SourcingArticleService;
import com.evai.testing.automation.api.data.model.GeneratorRequestEntry;
import com.evai.testing.automation.api.generators.article.SyntheticArticle;
import com.evai.testing.automation.api.util.ApiDescriptions;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@Slf4j
@RequestMapping(value = "/test-automation/articles-generator")
@AllArgsConstructor
@RestController
public class ArticleGeneratorController {
    private final ArticleGeneratorService generatorService;
    private final AnnotatorEntityService articleService;

    @Operation(description = ApiDescriptions.SYNTHETIC_ARTICLE_GENERATOR)
    @GetMapping("/generate/batch")
    public ResponseEntity<List<SyntheticArticle>> get(@RequestParam("composition") List<GeneratorRequestEntry> compositions) {
        generatorService.setSourceService(articleService);

        var articles = generatorService.batch(compositions);
        if(articles.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(articles);
    }

}
