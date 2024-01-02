package com.springboot.studentmanagement.Imports;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

import java.time.LocalDate;

public record UpdateStudentADetails(String student_name, String student_email, LocalDate student_dob) {

}
