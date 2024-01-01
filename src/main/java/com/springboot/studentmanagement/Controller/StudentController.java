package com.springboot.studentmanagement.Controller;

import com.springboot.studentmanagement.Entities.Students;
import com.springboot.studentmanagement.Services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {
    // Getting the Students Services
    @Autowired
    private final StudentService studentService;

   // Inserting Students
    @PostMapping()
    public Students insertStudent(@RequestBody Students students){
        return this.studentService.insertStudent(students);
    }

    // For Display All Students
    @GetMapping()
    public List<Students> getAllStudents(){
        return this.studentService.getAllStudents();
    }


}
