package com.todo.todobackend.persistence.repositories;

import com.todo.todobackend.persistence.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
