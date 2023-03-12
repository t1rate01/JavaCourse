package com.courseproject.projectdemo.data;

import java.util.List;

public interface IActiveCourse {
    public void addStudents(Student student);
    public void removeStudents(Student student);
    public List<Student> getStudents();
}
