package com.example.demo.dto;

import lombok.Builder;

@Builder
public record PetDto (
            Integer id,
            String name,
            String type,
            int age
    ) {}
