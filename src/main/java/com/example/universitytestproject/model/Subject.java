package com.example.universitytestproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subjects")
@Data
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int auditory;
    @ManyToOne
    private Professor professor;

    public Subject(String name, int auditory, Professor professor) {
        this.name = name;
        this.auditory = auditory;
        this.professor = professor;
    }
}
