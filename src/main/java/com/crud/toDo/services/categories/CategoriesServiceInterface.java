package com.crud.toDo.services.categories;

import com.crud.toDo.models.dto.CategoriesDto;

import java.util.List;

public interface CategoriesServiceInterface {

    public List<CategoriesDto> list();          //get the list of categories
    public CategoriesDto save(CategoriesDto categoriesDto);   //save a new toDho
    public void delete(Long id);                        //delete a toDho
    public CategoriesDto getIdDto (Long id);            //get the toDho id

 }
