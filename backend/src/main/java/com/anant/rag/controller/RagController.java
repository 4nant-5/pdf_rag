package com.anant.rag.controller;

import com.anant.rag.service.RagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rag")
@RequiredArgsConstructor
public class RagController {

    private final RagService ragService;

    @GetMapping
    public String ask(
            @RequestParam String question
    ) {
        return ragService.ask(question);
    }
}