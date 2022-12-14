package com.todo.todobackend.controllers;

import com.todo.todobackend.persistence.entities.Task;
import com.todo.todobackend.persistence.entities.TaskStatus;
import com.todo.todobackend.services.TaskService;
import com.todo.todobackend.services.dtos.TaskDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping()
    public Task create(@RequestBody TaskDto taskDto){
        return this.taskService.create(taskDto);
    }

    @GetMapping
    public List<Task> findAll(){
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(TaskStatus status) {
        return this.taskService.findAllByStatus(status);
    }

    @PatchMapping("/mark-as-finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable Long id) {
        this.taskService.markAsFinished(id);
        return ResponseEntity.noContent().build();
    }
}
