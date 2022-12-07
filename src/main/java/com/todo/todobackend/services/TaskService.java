package com.todo.todobackend.services;

import com.todo.todobackend.mappers.TaskDtoToTaskMapper;
import com.todo.todobackend.persistence.entities.Task;
import com.todo.todobackend.persistence.repositories.TaskRepository;
import com.todo.todobackend.services.dtos.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskDtoToTaskMapper taskDtoToTaskMapper;

    public TaskService(TaskRepository taskRepository, TaskDtoToTaskMapper taskDtoToTaskMapper) {
        this.taskRepository = taskRepository;
        this.taskDtoToTaskMapper = taskDtoToTaskMapper;
    }

    public Task create(TaskDto taskDto){
        return this.taskRepository.save(this.taskDtoToTaskMapper.map(taskDto));
    }

    public List<Task> findAll(){
        return this.taskRepository.findAll();
    }
}
