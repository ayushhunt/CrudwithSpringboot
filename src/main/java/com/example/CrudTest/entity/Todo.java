package com.example.CrudTest.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @NotBlank(message = "Todo Title must not be empty")
    @Size(max=100,message = "Todo title must not exceed 100 characters")
    private String title;
    @Column
    @Size(max = 500, message = "Description must not exceed 500 chars")
    private String description;
    @Column
    private boolean done;
    @Column
    @Min(value = 0)
    @Max(value = 30)
    private int duration;
}
