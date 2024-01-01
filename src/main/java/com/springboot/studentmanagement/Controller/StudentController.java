package com.springboot.studentmanagement.Controller;

import com.springboot.studentmanagement.Entities.Students;
import com.springboot.studentmanagement.Services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {
    // Getting the Students Services
    @Autowired
    private final StudentService studentService;

   // Inserting Students Data
    @PostMapping()
    public Students insertStudent(@RequestBody Students students){
        return this.studentService.insertStudent(students);
    }

    // For Display All Students Data
    @GetMapping()
    public List<Students> getAllStudents(){
        return this.studentService.getAllStudents();
    }

    // For Display Single Student Data
    @PostMapping("{student_id}")
    public Optional<Students> getStudents(@PathVariable("student_id")Long student_id){
        return this.studentService.getStudents(student_id);
    }

    // For Deleting Student Data
    @DeleteMapping("{student_id}")
    public void deleteStudent(@PathVariable("student_id") Long student_id){

    }


}
