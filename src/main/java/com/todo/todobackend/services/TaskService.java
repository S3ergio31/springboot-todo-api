package com.todo.todobackend.services;

import com.todo.todobackend.exceptions.ToDoException;
import com.todo.todobackend.mappers.TaskDtoToTaskMapper;
import com.todo.todobackend.persistence.entities.Task;
import com.todo.todobackend.persistence.entities.TaskStatus;
import com.todo.todobackend.persistence.repositories.TaskRepository;
import com.todo.todobackend.services.dtos.TaskDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public List<Task> findAllByStatus(TaskStatus status) {
        return this.taskRepository.findAllByStatus(status);
    }

    @Transactional
    public void markAsFinished(Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);

        if(optionalTask.isEmpty()) {
            throw new ToDoException("Task not found", HttpStatus.NOT_FOUND);
        }

        this.taskRepository.markAsFinished(id);
    }
}
