package com.crud.toDo.services.toDo;

import com.crud.toDo.models.dto.ToDoDto;
import com.crud.toDo.models.entities.Categories;
import com.crud.toDo.models.entities.ToDo;
import com.crud.toDo.models.mapper.ToDoMapper;
import com.crud.toDo.repository.toDo.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ToDoService implements ToDoServiceInterface{

    @Autowired
    ToDoRepository toDoRepository;

    @Autowired
    ToDoMapper toDoMapper;

    @Override
    public List<ToDoDto> getToDos() {
        List<ToDo> toDos = toDoRepository.findAll();
        return toDoMapper.toToDoDtos(toDos);
    }

    @Override
    public ToDoDto saveToDo(ToDoDto toDoDto) {
       ToDo toDo = toDoMapper.toToDo(toDoDto);
        return toDoMapper.toToDoDto(toDoRepository.save(toDo));
    }

    @Override
    public void deleteToDo(Long id) {
        toDoRepository.delete(toDoMapper.toToDo(getToDoIdDto(id)));

    }

    @Override
    public ToDoDto getToDoIdDto(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow();
        return toDoMapper.toToDoDto(toDo);
    }
}
