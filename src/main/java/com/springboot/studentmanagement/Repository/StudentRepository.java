package com.springboot.studentmanagement.Repository;

import com.springboot.studentmanagement.Entities.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Students,Long> {

    @Query("SELECT COUNT(s) > 0 FROM Students s WHERE s.student_email = ?1")
    boolean existsByStudentEmail(String studentEmail);

}
