package com.parsa.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parsa.security.model.StudentModel;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

    private List<StudentModel> students = new ArrayList<StudentModel>(List.of(
            new StudentModel(1, "Ali", 90),
            new StudentModel(2, "Reza", 85),
            new StudentModel(3, "Sara", 95)));

    @GetMapping("/students")
    public List<StudentModel> getStudents() {
        return students;
    }


    @GetMapping("/token")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/addstudent")
    public StudentModel addStudent(@RequestBody StudentModel student) {
        students.add(student);
        return student;
    }
}
