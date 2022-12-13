package com.codestates.todoapp.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequestDto {
    private String title;
    private Long order;
    private Boolean completed;
}
