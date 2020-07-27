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

    //ADD
    public Category saveCategory(Category category) {
        return repository.save(category);
    }

    public List<Category> saveCategories(List<Category> categories){
        return repository.saveAll(categories);
    }
    //GET
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
    //UPDATE
    public Category updateCategory(Category NewCategory, int id) throws ResourceNotFoundException{

        Category catRecord = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found for this id :: " + id));
        catRecord.setName(NewCategory.getName());
        return repository.save(catRecord);

    }
    //DELETE
   public String deleteCategory(int id) throws ResourceNotFoundException{

       Category catRecord = repository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Category could not be deleted,did not found this id :: " + id));
        repository.deleteById(catRecord.getId());
       return "Deleted id :: " + id;
        }


}
