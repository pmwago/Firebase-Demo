package com.example.firebasedemo;

public class Student {
    String id;
    private String regNo;
    private String firstName;
    private String lastName;
    private String course;
    private String year;

    //constructor

    public Student(String id,String regNo, String firstName, String lastName, String course, String year) {
        this.id=id;
        this.regNo = regNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.year = year;
    }
    public Student(){

    }
    public String getRegNo() {
        return regNo;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
