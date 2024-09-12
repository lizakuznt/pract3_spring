package com.mpt.journal.service;

import com.mpt.journal.model.StudentModel;
import com.mpt.journal.repository.InMemoryStudentDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InMemoryStudentImpl implements StudentService {

    private final InMemoryStudentDAO studentRepository;

    public InMemoryStudentImpl(InMemoryStudentDAO studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentModel> findAllStudent() {
        return studentRepository.findAllStudent();
    }

    @Override
    public StudentModel createStudent(StudentModel student) {
        return studentRepository.createStudent(student);
    }

    @Override
    public StudentModel updateStudent(StudentModel student) {
        return studentRepository.updateStudent(student);
    }

    @Override
    public StudentModel findStudentById(Long id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }
}