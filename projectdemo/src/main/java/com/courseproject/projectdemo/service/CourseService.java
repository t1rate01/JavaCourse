package com.courseproject.projectdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.courseproject.projectdemo.data.CPPCourse;
import com.courseproject.projectdemo.data.Course;
import com.courseproject.projectdemo.data.JavaCourse;
import com.courseproject.projectdemo.data.PythonCourse;
import com.courseproject.projectdemo.data.Student;

@Service
public class CourseService {
    private List<Course> courses = new ArrayList<>();
    private List <Student> students = new ArrayList<>();
      
    
    public CourseService() {  
        courses.add(new CPPCourse());
        courses.add(new JavaCourse());
        courses.add(new PythonCourse());
    }

    @PostConstruct  // huvin vuoksi kokeilla tätä käyttää alustukseen myös
    public void initStudentsToCourses() {
    
        students.add(new Student(1, "Matti", "Meikäläinen"));
        students.add(new Student(2, "Maija", "Mielikäinen"));
        students.add(new Student(3, "Mikko", "Mikkonen"));

        courses.get(0).addStudents(students.get(0));
        courses.get(0).addStudents(students.get(1));
        courses.get(1).addStudents(students.get(1));
        courses.get(1).addStudents(students.get(2));
        courses.get(2).addStudents(students.get(0));
        courses.get(2).addStudents(students.get(2));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public void newstudent(Student student) {
        students.add(student);
    }
        
 
    public List<Student> CourseStudentList(int id_course) {
        return courses.get(id_course).getStudents();
    }

    public String addStudentToCourse(int id_course, int id_student) {
        try {
            Student student = students.get(id_student);
            courses.get(id_course).getStudents().add(student);
        } catch (Exception e) {
            return "Error: Student not found";
        }
        return "Student added to course";
    }

    public String deleteStudentFromCourse(int id_course, int id_student) {
        try {
            courses.get(id_course).getStudents().remove(id_student);
        } catch (Exception e) {
            return "Error: Student not found";
        }
        return "Student deleted";
    }


    public List<Course> getAllCourses() {
        return courses;
    }

    public Course getCourse(int id) {
        try {
            return courses.get(id);
        } catch (Exception e) {
            return null;
        }
        
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public String updateCourse(int id_course) {
        Course course = courses.get(id_course);
      try {
        for (int i = 0; i < courses.size(); i++) {
            Course c = courses.get(i);
            if (c.getId_course() == course.getId_course()) {
                courses.set(i, course);
                return "Course updated";
            }
        }
      } catch (Exception e) {
          return "Error: Course not found";
      }
        return "Unknown error";
    }

    public String deleteCourse(int id) {
        try {
            for (int i = 0; i < courses.size(); i++) {
                Course c = courses.get(i);
                if (c.getId_course() == id) {
                    courses.remove(i);
                    return "Course deleted";
                }
            }
        } catch (Exception e) {
            return "Error: Course not found";
        }
        return "Unknown error";
}
}
