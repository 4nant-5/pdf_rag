package com.anant.rag.controller;

import com.anant.rag.service.EmbeddingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/embeddings")
@RequiredArgsConstructor
public class EmbeddingController {

    private final EmbeddingService embeddingService;

    @GetMapping
    public float[] embed(
            @RequestParam String text
    ) {
        return embeddingService.embed(text);
    }
}