package com.courseproject.projectdemo.data;

import java.util.List;

// Interface kursseille

public interface IActiveCourse {
    public void addStudents(Student student);
    public void removeStudents(Student student);
    public List<Student> getStudents();
}
