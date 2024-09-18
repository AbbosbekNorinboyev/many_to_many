package com.example.lesson8taskmanytomany.task1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String full_name;
    @Column(nullable = false, unique = true, length = 13)
    private String phone_number;
    @Column(nullable = false)
    private boolean gender;
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Subject> subject;
    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "teacher"
    )
    private List<Groups> groups;
}
