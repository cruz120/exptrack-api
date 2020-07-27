package com.example.expense.expensetracker.model;


import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.NotFound;
import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name="category")
@Setter
@Getter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;



}
