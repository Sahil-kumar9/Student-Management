package com.springboot.studentmanagement.Services;

import com.springboot.studentmanagement.Entities.Students;
import com.springboot.studentmanagement.Exceptions.Duplicate;
import com.springboot.studentmanagement.Exceptions.NotFound;
import com.springboot.studentmanagement.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class StudentServiceImplementations implements StudentService{

    @Autowired
    private final StudentRepository studentRepository;
    @Override
    public Students insertStudent(Students students) {
        // Check for the Duplicate Email
        if(studentRepository.existsByStudentEmail(students.getStudent_email())){
            throw new Duplicate("Email Already "+students.getStudent_email()+"Exists....");
        }
       return this.studentRepository.save(students);
    }

    @Override
    public List<Students> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Optional<Students> getStudents(Long student_id) {
        // Check if Student Id is Present or !
        if(!studentRepository.existsById(student_id)){
            throw new NotFound("Student Id " +student_id+" not Found...");
        }

        return this.studentRepository.findById(student_id);
    }

    @Override
    public void deleteStudent(Long student_id) {
        // Check if Student Id is Present or !
        if(!studentRepository.existsById(student_id)){
            throw new NotFound("Student Id " +student_id+" not Found...");
        }
        this.studentRepository.deleteById(student_id);
    }
}
