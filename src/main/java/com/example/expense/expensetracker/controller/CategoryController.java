package com.example.expense.expensetracker.controller;


import com.example.expense.expensetracker.Exception.ResourceNotFoundException;
import com.example.expense.expensetracker.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.expense.expensetracker.service.CategoryService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService service;


    @GetMapping("/categories")
    public List<Category> findAllCategories(){
        return service.getCategories();
        // select * from Category;
    }

    @GetMapping("/categoriesById/{id}")
    public ResponseEntity<?> getCategory(@PathVariable int id) {
         return service.getCategoryById(id);
          }

    @GetMapping("/categoryByName/{name}")
    public ResponseEntity<?> getCategoryName(@PathVariable String name) {
       return service.getCategoryByName(name);
         }




}
