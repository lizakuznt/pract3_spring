package com.mpt.journal.controller;

import com.mpt.journal.model.StudentModel;
import com.mpt.journal.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//Основная бизнес-логика нашего проекта
@Controller
public class StudentController {

    @Qualifier("studentServiceImpl")
    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public String getAllStudents(Model model) {
        List<StudentModel> students = studentService.findAllStudent();
        model.addAttribute("students", students);
        model.addAttribute("student", new StudentModel());
        return "students";
    }

    @PostMapping("/students")
    public String addStudent(@Valid @ModelAttribute StudentModel student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors: " + bindingResult.getAllErrors());
            List<StudentModel> students = studentService.findAllStudent();
            model.addAttribute("students", students);
            model.addAttribute("student", student);
            return "students";
        }
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        StudentModel student = studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "editStudent";
    }

    @PostMapping("/students/update")
    public String updateStudent(@Valid @ModelAttribute StudentModel student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors: " + bindingResult.getAllErrors());
            List<StudentModel> students = studentService.findAllStudent();
            model.addAttribute("students", students);
            model.addAttribute("student", student);
            return "students";
        }
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
