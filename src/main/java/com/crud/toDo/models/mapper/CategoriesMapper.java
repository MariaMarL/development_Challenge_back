package com.crud.toDo.models.mapper;

import com.crud.toDo.models.dto.CategoriesDto;
import com.crud.toDo.models.entities.Categories;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses={ToDoMapper.class})
public interface CategoriesMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "categoryName", target = "categoryName"),
            @Mapping(source = "toDoList", target = "toDoList")
    })
    CategoriesDto toCategoriesDto(Categories categories);
    List<CategoriesDto> toCategoriesDto(List<Categories> categories);

    @InheritInverseConfiguration
    Categories toCategories(CategoriesDto categoriesDto);
}
