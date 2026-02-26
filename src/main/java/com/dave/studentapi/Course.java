package com.dave.studentapi;

import com.dave.studentapi.entity.Student;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
//@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student>students=new ArrayList<>();



    private Course(){}

    public Course(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
//    public void addStudent(Student student){
//        students.add(student);
//        students.getCourses().add(this);
//    }
//    public void removeStudent(Student student) {
//        students.remove(student);
//        student.getCourses().remove(this);
//    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }
}
