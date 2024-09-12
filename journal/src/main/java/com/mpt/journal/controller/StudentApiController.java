package com.mpt.journal.controller;

import com.mpt.journal.model.StudentModel;
import com.mpt.journal.service.StudentService;
import com.mpt.journal.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/student")
public class StudentApiController {

    private final StudentService studentService;

    public StudentApiController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentModel> getAllStudents() {
        return studentService.findAllStudent();
    }

    @PostMapping
    public StudentModel createStudent(@RequestBody StudentModel student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping
    public void deleteStudent(@RequestBody StudentModel student) {
        studentService.deleteStudent(student.getId());
        return;
    }
}