package com.anant.rag.controller;

import com.anant.rag.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @PostMapping("/upload")
    public String upload(
            @RequestParam MultipartFile file
    ) throws Exception {

        documentService.ingest(file);

        return "Document ingested successfully";
    }
}