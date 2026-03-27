package com.example.buoi1.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3, max = 50,message = "title phai co tu 3 den 50 ky tu")
    private String title;
    @Size(min = 3,message = "dessritptipn toi thieu 3 ky tu")
    private String description;

    private Boolean completed;
}
