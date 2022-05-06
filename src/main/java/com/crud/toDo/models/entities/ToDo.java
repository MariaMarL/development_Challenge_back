package com.crud.toDo.models.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "toDo")
@Data
public class ToDo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    //generate a random id
    private Long id;
    private String task;
    private boolean done;
    private Long fkCategoryId;

}
