package com.anant.rag.controller;

import com.anant.rag.service.RetrievalService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.document.Document;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class RetrievalController {

    private final RetrievalService retrievalService;

    @GetMapping
    public List<Document> search(
            @RequestParam String question
    ) {
        return retrievalService.search(question);
    }
}