package com.springboot.studentmanagement.Services;

import com.springboot.studentmanagement.Entities.Students;

import java.util.List;
import java.util.Optional;

public interface StudentService {
        Students insertStudent(Students students);
        List<Students> getAllStudents();

        Optional<Students> getStudents(Long student_id);
}
