package com.dave.studentapi.controller;

import com.dave.studentapi.Course;
import com.dave.studentapi.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @PostMapping
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }
    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id){
        return courseService.getCourseById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
}
