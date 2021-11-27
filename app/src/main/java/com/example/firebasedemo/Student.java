package com.example.firebasedemo;

public class Student {
    private String regNo;
    private String firstName;
    private String lastName;
    private String course;
    private String year;

    //constructor

    public Student(String regNo, String firstName, String lastName, String course, String year) {
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

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
