package com.example.expense.expensetracker.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Instant expensedate;

    private double price;

    private String description;

    @ManyToOne
    //private int category_id_fk;
    private Category category;

    @ManyToOne
  //  private int user_id_fk;
    private User user;
}
