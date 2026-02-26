package com.dave.studentapi.service;

import com.dave.studentapi.Course;
import com.dave.studentapi.entity.Student;
import com.dave.studentapi.repository.CourseRepository;
import com.dave.studentapi.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseService(CourseRepository courseRepository,
                         StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    public Course createCourse(Course course){
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElseThrow(()-> new RuntimeException("Course not found"));
    }
    public Course enrollStudent(Long courseId, Long studentId){
        Course course=courseRepository.findById(courseId).orElseThrow(()->new RuntimeException("Course not found"));
        Student student=studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("Student not found"));

        course.addStudent(student);
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
    }
}
