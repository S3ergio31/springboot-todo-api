package com.todo.todobackend.mappers;

import com.todo.todobackend.persistence.entities.Task;
import com.todo.todobackend.persistence.entities.TaskStatus;
import com.todo.todobackend.services.dtos.TaskDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskDtoToTaskMapper implements Mapper <TaskDto, Task>{
    @Override
    public Task map(TaskDto in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
