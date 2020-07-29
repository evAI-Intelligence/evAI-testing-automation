package com.evai.testing.automation.api;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping(value = "/test-automation/articles-generator")
@AllArgsConstructor
@RestController
public class ArticleGeneratorController {

    private final ArticleGeneratorService service;
}
