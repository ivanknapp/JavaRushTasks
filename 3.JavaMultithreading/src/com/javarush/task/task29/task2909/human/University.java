package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double value) {
        //TODO:
        Student student = students.get(0);
        for (Student s : students) {
            if (s.getAverageGrade() == value)
                student = s;
        }
        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        double maxAverageGrade = students.get(0).getAverageGrade();
        Student student = students.get(0);
        for (Student s : students) {
            if (s.getAverageGrade() > maxAverageGrade) {
                maxAverageGrade = s.getAverageGrade();
                student = s;
            }
        }
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        double minAverageGrade = students.get(0).getAverageGrade();
        Student student = students.get(0);
        for (Student s : students) {
            if (s.getAverageGrade() < minAverageGrade) {
                minAverageGrade = s.getAverageGrade();
                student = s;
            }
        }
        return student;
    }

    public void expel(Student student){
        if (student!= null)
            getStudents().remove(student);
    }
}