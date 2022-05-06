package com.crud.toDo.services.categories;

import com.crud.toDo.models.dto.CategoriesDto;
import com.crud.toDo.models.entities.Categories;
import com.crud.toDo.models.mapper.CategoriesMapper;
import com.crud.toDo.repository.categories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService implements CategoriesServiceInterface{

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoriesMapper categoriesMapper;

    @Override
    public List<CategoriesDto> list() {
        List<Categories> categories = categoryRepository.findAll();
        return categoriesMapper.toCategoriesDto(categories);
    }

    @Override
    public CategoriesDto save(CategoriesDto categoriesDto) {   //recibo el dato en dto porque viene de la interfaz
        Categories categories = categoriesMapper.toCategories(categoriesDto);  //cambio a entity para pasar a la db
        return categoriesMapper.toCategoriesDto(categoryRepository.save(categories));
    }

    @Override
    public void delete(Long categoryId) {
       categoryRepository.delete(categoriesMapper.toCategories(getIdDto(categoryId)));
    }

    @Override
    public CategoriesDto getIdDto(Long id) {
        Categories categories =  categoryRepository.findById(id).orElseThrow();
        return categoriesMapper.toCategoriesDto(categories);
    }
}
