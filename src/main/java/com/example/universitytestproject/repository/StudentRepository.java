package com.example.universitytestproject.repository;

import com.example.universitytestproject.model.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "select s3.name from students s "
            + "join groups g on s.group_id = g.id "
            + "join groups_schedules gs on g.id = gs.group_id "
            + "join schedules s2 on s2.id = gs.schedule_id "
            + "join schedules_subjects ss on s2.id = ss.schedule_id "
            + "join subjects s3 on s3.id = ss.subject_id where s.id = ? and s2.day = ?;",
            nativeQuery = true)
    List<String> findByStudentIdAndDay(Long id, String day);
}
