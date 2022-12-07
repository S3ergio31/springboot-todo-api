package com.todo.todobackend.services.dtos;

import com.todo.todobackend.persistence.entities.TaskStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDto {
    private String title;
    private String description;
    private LocalDateTime eta;
}
