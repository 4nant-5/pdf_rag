package com.anant.rag.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;

    private LocalDateTime uploadedAt;
}