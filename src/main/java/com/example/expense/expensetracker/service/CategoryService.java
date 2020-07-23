package com.example.expense.expensetracker.service;


import com.example.expense.expensetracker.Exception.ResourceNotFoundException;
import com.example.expense.expensetracker.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.expense.expensetracker.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;


    public Category saveCategory(Category category) {

        return repository.save(category);
    }

    public List<Category> saveCategories(List<Category> categories){
        return repository.saveAll(categories);
    }

    public List<Category> getCategories(){
        return repository.findAll();
   }

    public ResponseEntity<?> getCategoryById(int id) throws ResourceNotFoundException{

        Category category = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + id));
        return ResponseEntity.ok().body(category);
   }
    public ResponseEntity<?> getCategoryByName(String name) throws  ResourceNotFoundException {

        Optional<Category> category = Optional.ofNullable(repository.findByName(name));

        return category.map(response -> ResponseEntity.ok().body(category)).orElseThrow(() -> new ResourceNotFoundException("Category not found this name :: "+name));
    }

   public String deleteCategory(int id){
       repository.deleteById(id);
       return "Removed : " + id;
        }


}
