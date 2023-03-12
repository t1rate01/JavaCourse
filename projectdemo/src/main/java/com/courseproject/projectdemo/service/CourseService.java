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
      
    
    public CourseService() {     // luodaan konstruktorissa demotukseen kolme kurssia
        courses.add(new CPPCourse());
        courses.add(new JavaCourse());
        courses.add(new PythonCourse());
    }

    @PostConstruct  // huvin vuoksi kokeilla tätä käyttää alustukseen myös
    public void initStudentsToCourses() {
    
        students.add(new Student(1, "Matti", "Meikäläinen"));
        students.add(new Student(2, "Maija", "Mielikäinen"));
        students.add(new Student(3, "Mikko", "Mikkonen"));

        courses.get(0).addStudents(students.get(0));  // lisätään kurssille opiskelijat
        courses.get(0).addStudents(students.get(1));  // käytetään listametodeja
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
        
 
    public List<Student> CourseStudentList(int id_course) {   // palauttaa kurssin opiskelijat
        return courses.get(id_course).getStudents();
    }

    public String addStudentToCourse(int id_course, int id_student) {  // lisää opiskelijan kurssille
        try {
            Student student = students.get(id_student);
            courses.get(id_course).getStudents().add(student);
        } catch (Exception e) {
            return "Error: Student not found";
        }
        return "Student added to course";
    }

    public String deleteStudentFromCourse(int id_course, int id_student) {  // poistaa opiskelijan kurssilta
        try {
            courses.get(id_course).getStudents().remove(id_student);
        } catch (Exception e) {
            return "Error: Student not found";
        }
        return "Student deleted";
    }


    public List<Course> getAllCourses() {  // palauttaa kaikki kurssit
        return courses;
    }

    public Course getCourse(int id) {  // palauttaa yhden kurssin
        try {
            return courses.get(id);
        } catch (Exception e) {
            return null;                // tämä funktio voisi myös olla String, jolloin voisi palauttaa Stringin ja olisi ehkä http-pyynnössä parempi
        } 
    }
  
    public String getCourse2(int id){    // String toteutuksena aiempi funktio HOX POLKU GetMapping
         try {
            String x = courses.get(id).getName_course().toString();
            int y = courses.get(id).getId_course();
            int z = courses.get(id).getECTS_course();
            return "Course name: " + x + ", Course ID: " + y + ", ECTS: " + z;
    }
            catch (Exception e) {
                return "Error: Course not found";
            }
        }

    public void addCourse(Course course) {  // lisää uuden kurssin
        courses.add(course);
    }

    public String updateCourse(int id_course) {  
        Course course = courses.get(id_course);
      try {
        for (int i = 0; i < courses.size(); i++) {    // käy koko kurssi-listan läpi
            Course c = courses.get(i);
            if (c.getId_course() == course.getId_course()) {   // jos löytyy täsmäävä kurssi
                courses.set(i, course);                         // päivitetään se   
            }
        }
      } catch (Exception e) {
          return "Error: Course not found";
      }
      return "Course updated";    
    }                              

    public String deleteCourse(int id) {
        try {
            for (int i = 0; i < courses.size(); i++) {  // käy koko kurssi-listan läpi
                Course c = courses.get(i);              // jos löytyy täsmäävä kurssi
                if (c.getId_course() == id) {           // poistetaan se
                    courses.remove(i);  
                }
            }
        } catch (Exception e) {
            return "Error: Course not found";  // jos ei löydy, palautetaan virheilmoitus
        }
        return "Course deleted";
}
}
