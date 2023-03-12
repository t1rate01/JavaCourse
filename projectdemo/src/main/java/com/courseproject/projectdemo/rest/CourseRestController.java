package com.courseproject.projectdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.courseproject.projectdemo.data.Course;
import com.courseproject.projectdemo.data.Student;
import com.courseproject.projectdemo.service.CourseService;

@RestController
public class CourseRestController {
    // MUISTA LAITTAA TÄNNE @Autowired

    CourseService courseService;

    @Autowired
    public CourseRestController(CourseService courseService) {
        this.courseService = courseService;
    }

    // TÄHÄN KAIKKI REST CONTROLLERIT

    @GetMapping("/courses")
    public List<Course> getCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{id_course}/students")
    public List<Student> getStudentsFromCourse(@PathVariable int id_course) {
        return courseService.CourseStudentList(id_course);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return courseService.getAllStudents();
    }

    @GetMapping("/courses/{id_course}")
    public Course getCourse(@PathVariable int id_course) {
        return courseService.getCourse(id_course);
    }

    @PostMapping("/students")
    public String postStudent(@RequestBody Student student) {
        courseService.newstudent(student);
        return "Student added";
    }

    @PostMapping("/courses/{id_course}/{id_student}")
    public String postStudentToCourse(@PathVariable int id_course, @PathVariable int id_student) {
        return courseService.addStudentToCourse(id_course, id_student);
    }

    @PostMapping("/courses")
    public String postCourse(@RequestBody Course course) {
     try {
         courseService.addCourse(course);
         return "Course added";
        } catch (Exception e) {
            return "Error adding course";
        }
    }

    @DeleteMapping("/courses/{id_course}")
    public String deleteCourse(@PathVariable int id_course) {
         return courseService.deleteCourse(id_course); 
    }

    @PutMapping("/courses/{id_course}")
    public String updateCourse(@PathVariable int id_course, @RequestBody Course course) {
        return courseService.updateCourse(id_course);
    }




    

}
