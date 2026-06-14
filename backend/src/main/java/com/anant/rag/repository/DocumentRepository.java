package com.anant.rag.repository;

import com.anant.rag.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository
        extends JpaRepository<Document, Long> {
}