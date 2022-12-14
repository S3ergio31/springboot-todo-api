package com.todo.todobackend.persistence.repositories;

import com.todo.todobackend.persistence.entities.Task;
import com.todo.todobackend.persistence.entities.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    public List<Task> findAllByStatus(TaskStatus status);

    @Modifying
    @Query(value = "UPDATE tasks SET finished = true WHERE id = :id", nativeQuery = true)
    public void markAsFinished(@Param("id") Long id);
}
