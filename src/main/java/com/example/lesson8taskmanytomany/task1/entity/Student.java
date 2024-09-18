package com.example.lesson8taskmanytomany.task1.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String full_name;
    @Column(nullable = false, unique = true, length = 13)
    private String phone_number;
    @Column(nullable = false, updatable = false)
    private String birth_date;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Groups groups;
}
