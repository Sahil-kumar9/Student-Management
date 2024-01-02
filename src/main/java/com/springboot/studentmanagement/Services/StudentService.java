package com.springboot.studentmanagement.Services;

import com.springboot.studentmanagement.Entities.Students;
import com.springboot.studentmanagement.Imports.UpdateStudentADetails;
import jakarta.persistence.Transient;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StudentService {
        Students insertStudent(Students students);
        List<Students> getAllStudents();

        Optional<Students> getStudents(Long student_id);

        void deleteStudent(Long student_id);

        void updateStudent(UpdateStudentADetails updateStudentADetails,Long student_id);
}
