package com.codestates.todoapp.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoPostDto {
    private String title;
    private Long order;
    private Boolean completed;
}
