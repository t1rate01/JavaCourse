package com.courseproject.projectdemo.data;
import java.util.ArrayList;
import java.util.List;


public class Course {
    private int id_course;
    private String name_course;
    private int ECTS_course;
    private List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(Student student) {
        students.add(student);
    }

    public void removeStudents(Student student) {
        students.remove(student);
    }

    //public Course() {
   // }

    public Course(int id_course, String name_course, int ECTS_course) {
        this.id_course = id_course;
        this.name_course = name_course;
        this.ECTS_course = ECTS_course;
    }

    public int getId_course() {
        return this.id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public String getName_course() {
        return this.name_course;
    }

    public void setName_course(String name_course) {
        this.name_course = name_course;
    }

    public int getECTS_course() {
        return this.ECTS_course;
    }

    public void setECTS_course(int ECTS_course) {
        this.ECTS_course = ECTS_course;
    }


}
