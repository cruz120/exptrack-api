package com.example.expense.expensetracker.controller;


import com.example.expense.expensetracker.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.expense.expensetracker.service.CategoryService;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService service;
    //ADD
    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category){
        return service.saveCategory(category);
    }
    @PostMapping("/addCategories")
    public List<Category> addCategories(@RequestBody List<Category> categories){
        return service.saveCategories(categories);
    }
    //GET
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
    //UPDATE
    @PutMapping("/updateCategory/{id}")
    public Category updateCategory(@RequestBody Category category, @PathVariable int id){
        return service.updateCategory(category,id);
    }
    //DELETE
    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable int id){
        return service.deleteCategory(id);
    }


}
