package com.mpt.journal.service;

import com.mpt.journal.model.StudentModel;
import java.util.List;

public interface StudentService {
    List<StudentModel> findAllStudent();
    StudentModel createStudent(StudentModel student);
    StudentModel updateStudent(StudentModel student);
    StudentModel findStudentById(Long id);
    void deleteStudent(Long id);
}
