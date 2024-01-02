package com.springboot.studentmanagement.Services;

import com.springboot.studentmanagement.Entities.Students;
import com.springboot.studentmanagement.Exceptions.Duplicate;
import com.springboot.studentmanagement.Exceptions.NotFound;
import com.springboot.studentmanagement.Imports.UpdateStudentADetails;
import com.springboot.studentmanagement.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

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
            throw new Duplicate("Email Already "+students.getStudent_email()+" Exists....");
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

    @Override
    public void updateStudent(UpdateStudentADetails updateStudentADetails,Long student_id) {
        boolean change = false;
        Optional<Students> optionalStudents = studentRepository.findById(student_id.longValue());
        Students existingData = optionalStudents.get();

        // Check if Student Id is Present or !
        if (optionalStudents.isEmpty()) {
        throw new NotFound("Student Id " + student_id + " not Found!!!!");
        }

        // Check if Name is Duplicate or null
        if(updateStudentADetails.student_name()!=null && !updateStudentADetails.student_name().equals(existingData.getStudent_name())){
            existingData.setStudent_name(updateStudentADetails.student_name());
            change = true;
        }

        // Check if Email is Duplicate or null
        if(updateStudentADetails.student_email()!=null && !updateStudentADetails.student_email().equals(existingData.getStudent_email())){
            // Check if Email is Duplicate or !
            if(studentRepository.existsByStudentEmail(updateStudentADetails.student_email())){
                throw new Duplicate("Email Already "+updateStudentADetails.student_email()+" Exists....");
            }
            existingData.setStudent_email(updateStudentADetails.student_email());
            change = true;
        }

        // Check if Date of Birth is Duplicate or null
        if(updateStudentADetails.student_dob()!=null && !updateStudentADetails.student_dob().equals(existingData.getStudent_dob())){
            existingData.setStudent_dob(updateStudentADetails.student_dob());
            change = true;
        }

        if(change){
            studentRepository.save(existingData);
        } else {
            throw new NotFound("No Data Change Found!!!");
        }
    }
}

