package com.todo.todobackend.mappers;

public interface Mapper <I, O>{
    public O map(I in);
}
