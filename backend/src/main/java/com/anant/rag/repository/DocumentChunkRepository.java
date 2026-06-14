package com.anant.rag.repository;

import com.anant.rag.entity.DocumentChunk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentChunkRepository
        extends JpaRepository<DocumentChunk, Long> {
}