package com.example.buoi1.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRequest {
    @Size(min = 4, max = 50,message = "title phai tu 3 den 50 ky tu")
    private String title;
    private String author;
    private Double price;
}
