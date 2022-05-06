package com.crud.toDo.services.toDo;

import com.crud.toDo.models.dto.ToDoDto;

import java.util.List;

public interface ToDoServiceInterface {

    public List<ToDoDto> getToDos();
    public  ToDoDto saveToDo(ToDoDto toDoDto);
    public void deleteToDo(Long id);
    public ToDoDto getToDoIdDto(Long id);

}
