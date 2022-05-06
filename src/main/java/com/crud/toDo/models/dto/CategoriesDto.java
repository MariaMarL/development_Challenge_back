package com.crud.toDo.models.dto;

import java.util.List;

public class CategoriesDto {

    private Long id;;
    private String categoryName;;
    private List<ToDoDto> toDoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return categoryName;
    }

    public void setName(String name) {
        this.categoryName = name;
    }

    public List<ToDoDto> getListOfToDo() {
        return toDoList;
    }

    public void setListOfToDo(List<ToDoDto> listOfToDo) {
        toDoList = listOfToDo;
    }
}
