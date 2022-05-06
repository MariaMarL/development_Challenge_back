package com.crud.toDo.models.mapper;


import com.crud.toDo.models.dto.ToDoDto;
import com.crud.toDo.models.entities.ToDo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel= "spring")
public interface ToDoMapper {

    @Mappings({
            @Mapping(source="id", target="id"),
            @Mapping(source="task", target="task"),
            @Mapping(source = "done", target="done"),
            @Mapping(source="fkCategoryId", target="fkCategoryId"),
    })
    ToDoDto toToDoDto(ToDo toDo);         // de ToDo a ToDoDto
    List<ToDoDto> toToDoDtos(List<ToDo> toDo);

    @InheritInverseConfiguration        //de ToDoDto a ToDo
    ToDo toToDo(ToDoDto toDoDto);
}
