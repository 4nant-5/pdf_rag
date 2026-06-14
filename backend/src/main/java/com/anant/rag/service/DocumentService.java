package com.anant.rag.service;

import com.anant.rag.entity.Document;
import com.anant.rag.entity.DocumentChunk;
import com.anant.rag.repository.DocumentChunkRepository;
import com.anant.rag.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {

    private final DocumentRepository documentRepository;
    private final DocumentChunkRepository documentChunkRepository;

    private final PdfService pdfService;
    private final ChunkingService chunkingService;
    private final EmbeddingService embeddingService;
    private final VectorStoreService vectorStoreService;

    public void ingest(MultipartFile file) throws Exception {

        // Extract text
        String text = pdfService.extractText(file);

        // Chunk text
        List<String> chunks = chunkingService.chunkText(text);

        // Save document metadata
        Document document = Document.builder()
                .filename(file.getOriginalFilename())
                .uploadedAt(LocalDateTime.now())
                .build();

        document = documentRepository.save(document);

        // Save chunks in relational database
        for (String chunk : chunks) {

            float[] embeddingVector =
                    embeddingService.embed(chunk);

            String embedding =
                    Arrays.toString(embeddingVector);

            DocumentChunk documentChunk =
                    DocumentChunk.builder()
                            .document(document)
                            .content(chunk)
                            .embedding(embedding)
                            .build();

            documentChunkRepository.save(documentChunk);
        }

        // Save chunks in PgVectorStore
        vectorStoreService.saveChunks(chunks);
    }
}