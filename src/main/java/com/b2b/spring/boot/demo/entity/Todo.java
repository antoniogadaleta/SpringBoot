package com.b2b.spring.boot.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Todo {
    private Long userId;
    private Long id;
    private String title;
    private Boolean completed;
}
