package com.anant.rag.controller;


import com.anant.rag.service.PdfService;
import com.anant.rag.service.ChunkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final PdfService pdfService;
    private final ChunkingService chunkingService;

    @PostMapping("/upload")
    public List<String> upload(
            @RequestParam MultipartFile file
    ) throws Exception {

        String text = pdfService.extractText(file);
        return chunkingService.chunkText(text);
    }
}