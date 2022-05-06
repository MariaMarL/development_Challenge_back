package com.crud.toDo.controller;

import com.crud.toDo.models.dto.ToDoDto;
import com.crud.toDo.services.categories.CategoriesService;
import com.crud.toDo.services.categories.CategoriesServiceInterface;
import com.crud.toDo.services.toDo.ToDoService;
import com.crud.toDo.services.toDo.ToDoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")                            //the url when we execute the request.
@CrossOrigin(origins = "http://localhost:3000")   //tell that accepts request from a fronted app; tell that it will be an origin localed in the localhost.
public class ToDoController {

    @Autowired //dependency injection without making an instance from this class.
    private ToDoServiceInterface toDoServiceInterface;

    @Autowired
    private CategoriesServiceInterface categoriesServiceInterface;

    @GetMapping (value = "get/todos")
    public List<ToDoDto> getToDos(){
        return toDoServiceInterface.getToDos();
    }

    @PostMapping(value = "save/todo")
    public ToDoDto save(@RequestBody ToDoDto toDoDto){
        return toDoServiceInterface.saveToDo(toDoDto);
    }

   @PutMapping(value = "put/todo")
   public ToDoDto update(@RequestBody ToDoDto toDoDto){
       if(toDoDto.getId() != null){
           return toDoServiceInterface.saveToDo(toDoDto);
       }
       throw new RuntimeException("This toDo doesn't exist");

   }

   @DeleteMapping("delete/todo/{id}")
    public void delete(@PathVariable Long id){
        toDoServiceInterface.deleteToDo(id);
   }

   @GetMapping(value = "/todo/{id}")
    public ToDoDto getTodo(@PathVariable Long id){
        return toDoServiceInterface.getToDoIdDto(id);
   }
}
