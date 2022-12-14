package se.iths.HealthApp.entity;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class ResistanceTrainingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String muscleGroup;
    private Long numberOfRepetitions;
    private LocalDate createdAt;

    @ManyToMany(mappedBy = "resistanceTrainings")
    private List<UserEntity> users;


    public ResistanceTrainingEntity() {
    }

    @PrePersist
    public void getCurrentDate() {
        setCreatedAt(LocalDate.now());
    }

    public void addUser(UserEntity user) {
        users.add(user);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(String group) {
        this.muscleGroup = group;
    }

    public Long getNumberOfRepetitions() {
        return numberOfRepetitions;
    }

    public void setNumberOfRepetitions(Long numberOfRepetitions) {
        this.numberOfRepetitions = numberOfRepetitions;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
