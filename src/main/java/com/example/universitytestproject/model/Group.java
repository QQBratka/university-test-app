package com.example.universitytestproject.model;

import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "groups")
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Speciality speciality;
    @ManyToMany
    @JoinTable(name = "groups_professors",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "professor_id"))
    private List<Professor> professors;
    @OneToMany
    @JoinTable(name = "groups_schedules",
            joinColumns = @JoinColumn(name = "group_id"),
            inverseJoinColumns = @JoinColumn(name = "schedule_id"))
    private List<Schedule> weekSchedule;

    public Group(Speciality speciality,
                 List<Professor> professors,
                 List<Schedule> weekSchedule) {
        this.speciality = speciality;
        this.professors = professors;
        this.weekSchedule = weekSchedule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(id, group.id) && speciality == group.speciality && Objects.equals(professors, group.professors) && Objects.equals(weekSchedule, group.weekSchedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, speciality, professors, weekSchedule);
    }
}
