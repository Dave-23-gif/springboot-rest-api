package com.dave.studentapi.repository;

import com.dave.studentapi.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
