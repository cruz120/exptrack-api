package com.example.expense.expensetracker.repository;

import com.example.expense.expensetracker.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository extends JpaRepository<Category, Integer> {


    Category findByName(String name);

}
