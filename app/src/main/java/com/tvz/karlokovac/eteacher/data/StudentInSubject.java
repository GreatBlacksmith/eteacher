package com.tvz.karlokovac.eteacher.data;

import java.util.ArrayList;
import java.util.List;

public class StudentInSubject {
    private String studentName = null;
    private List<String> grades = new ArrayList<>();

    public StudentInSubject(String studentName, List<String> grades) {
        this.studentName = studentName;
        this.grades = grades;
    }

    public StudentInSubject() {
    }

    public String getStudentName() {
        return studentName;
    }

    public List<String> getGrades() {
        return grades;
    }

    public void setGrades(List<String> grades) {
        this.grades = grades;
    }
}
