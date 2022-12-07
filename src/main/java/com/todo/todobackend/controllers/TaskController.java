package com.todo.todobackend.controllers;

import com.todo.todobackend.persistence.entities.Task;
import com.todo.todobackend.services.TaskService;
import com.todo.todobackend.services.dtos.TaskDto;
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
}
