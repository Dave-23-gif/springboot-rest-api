package com.dave.studentapi.service;

import com.dave.studentapi.entity.Student;
import com.dave.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student not found"));
    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
