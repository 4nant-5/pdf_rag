package com.anant.rag.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "document_chunks")
public class DocumentChunk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long documentId;

    @Column(columnDefinition = "TEXT")
    private String content;
}