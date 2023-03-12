package com.courseproject.projectdemo.data;


// yksinkertainen student luokka, funktiot autogeneroitu
public class Student {
    private int id_student;
    private String name_student;
    private String surname_student;

    public Student() {
    }

    public Student(int id_student, String name_student, String surname_student) {
        this.id_student = id_student;
        this.name_student = name_student;
        this.surname_student = surname_student;
    }

    public int getId_student() {
        return this.id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getName_student() {
        return this.name_student;
    }

    public void setName_student(String name_student) {
        this.name_student = name_student;
    }

    public String getSurname_student() {
        return this.surname_student;
    }

    public void setSurname_student(String surname_student) {
        this.surname_student = surname_student;
    }

}
