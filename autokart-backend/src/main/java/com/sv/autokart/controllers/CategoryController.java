package com.sv.autokart.controllers;

import com.sv.autokart.models.Categories;
import com.sv.autokart.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Categories>> getAllCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<String> createNewCategory(@RequestBody Categories categories){
        categoryService.saveCategory(categories);
        return ResponseEntity.status(HttpStatus.CREATED).body("Category create successfully");
    }

    @PutMapping("/{categoryid}")
    public ResponseEntity<String> updateCategory(@PathVariable Long categoryid, @RequestBody Categories categories){
        categoryService.updateCategory(categoryid,categories);
        return ResponseEntity.status(HttpStatus.OK).body("Category updated successfully");
    }

    @DeleteMapping("/{categoryid}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryid){
        categoryService.deleteCategory(categoryid);
        return ResponseEntity.status(HttpStatus.OK).body("Category deleted successfully");
    }
}
