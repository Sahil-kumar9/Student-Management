package com.springboot.studentmanagement.Dummies;

import com.springboot.studentmanagement.Controller.StudentController;
import com.springboot.studentmanagement.Entities.Students;
import com.springboot.studentmanagement.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class InsertingDummiesData implements CommandLineRunner {

    private final StudentRepository studentRepository;
    @Override
    public void run(String... args) throws Exception {
        List<Students> STUDENT_LIST = Arrays.asList(new Students(
                "Sahil",
                "sahil@gmail.com",
                LocalDate.of(2000,02,05)),
                new Students("Raju",
                        "raju@gmail.com",
                        LocalDate.of(1999,10,21)));
        System.out.println(STUDENT_LIST);
        this.studentRepository.saveAll(STUDENT_LIST);

    }
}
