package com.springboot.studentmanagement.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Getter @Setter @Table(name = "students")
public class Students {

    @SequenceGenerator(name = "student_id", sequenceName = "student_id",initialValue = 12321)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_id")
    @Id
    private Long student_id;
    @Column(nullable = false)
    private String student_name;
    @Column(nullable = false,unique = true)
    private String student_email;
    @Column(nullable = false)
    private LocalDate student_dob;
    @Column(nullable = false)
    private int student_age;

    public Students(String student_name, String student_email, LocalDate student_dob) {
        this.student_name = student_name;
        this.student_email = student_email;
        this.student_dob = student_dob;
        this.calculateAge();
    }

//    public Students(String student_name, String student_email, LocalDate student_dob, int student_age) {
//        this.student_name = student_name;
//        this.student_email = student_email;
//        this.student_dob = student_dob;
//        this.student_age = student_age;
//    }

    @PrePersist
    @PreUpdate
    private void calculateAge(){
        if(this.student_dob!=null){
            this.student_age = Period.between(student_dob,LocalDate.now()).getYears();
        }
    }


}
