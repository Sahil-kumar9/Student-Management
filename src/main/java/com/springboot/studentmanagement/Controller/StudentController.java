package com.springboot.studentmanagement.Controller;

import com.springboot.studentmanagement.Entities.Students;
import com.springboot.studentmanagement.Exceptions.Duplicate;
import com.springboot.studentmanagement.Exceptions.NotFound;
import com.springboot.studentmanagement.Imports.UpdateStudentADetails;
import com.springboot.studentmanagement.Services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<Map<String,String>> insertStudent(@RequestBody Students students){
        //return this.studentService.insertStudent(students);
        try{
            Map<String,String> response = new HashMap<>();
            response.put("Message:","Student Data Saved Successfully!!!");
            this.studentService.insertStudent(students);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (Duplicate duplicate){
            Map<String,String> response = new HashMap<>();
            response.put("Message:",duplicate.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

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
    public ResponseEntity<Map<String,String>> deleteStudent(@PathVariable("student_id") Long student_id){
       try {
           Map<String,String> response = new HashMap<>();
           response.put("Message:","Deleted Sucessfullt");
           this.studentService.deleteStudent(student_id);
           return ResponseEntity.status(HttpStatus.OK).body(response);
       }catch (NotFound notFound){
           Map<String,String> response = new HashMap<>();
           response.put("Message:",notFound.getMessage());
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
       }
    }

    // For Updating Students Data
    @PutMapping("{student_id}")
    public ResponseEntity<Map<String,String>> updateStudent(@RequestBody UpdateStudentADetails updateStudentADetails,@PathVariable("student_id")Long student_id){
        try{
            this.studentService.updateStudent(updateStudentADetails,student_id);
            Map<String,String> response = new HashMap<>();
            response.put("Message:","Updated Sucessfully");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (Duplicate duplicate){
            Map<String,String> response = new HashMap<>();
            response.put("Message:",duplicate.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

}
