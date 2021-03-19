package com.sv.autokart.services;

import com.sv.autokart.exceptions.SpringAutoKartException;
import com.sv.autokart.models.Categories;
import com.sv.autokart.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Categories> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Transactional
    public void saveCategory(Categories categories){
        categoryRepository.save(categories);
    }

    @Transactional
    public void updateCategory(Long categoryId,Categories categories){
        Categories updatedCategory = categoryRepository.findById(categoryId).orElseThrow(()->new SpringAutoKartException("Catgory not found"));
        updatedCategory.setCategoryName(categories.getCategoryName());
        categoryRepository.save(updatedCategory);
    }

    @Transactional
    public void deleteCategory(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }
}
