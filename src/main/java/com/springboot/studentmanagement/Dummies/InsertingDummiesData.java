package com.springboot.studentmanagement.Dummies;

import com.springboot.studentmanagement.Controller.StudentController;
import com.springboot.studentmanagement.Entities.Students;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class InsertingDummiesData implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        List<Students> STUDENT_LIST = Arrays.asList(new Students(
                "Sahil",
                "sahil@gmail.com",
                LocalDate.of(2000,02,05)),
                new Students("Raju",
                        "raju@gmail.com",
                        LocalDate.of(1999,10,21)));
    }
}
