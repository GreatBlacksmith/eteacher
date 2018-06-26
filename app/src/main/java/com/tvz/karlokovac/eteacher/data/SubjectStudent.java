package com.tvz.karlokovac.eteacher.data;

import java.util.ArrayList;
import java.util.List;

public class SubjectStudent {
    private String subjectName = null;
    private String numberOfStudents = null;
    private String average = null;
    private List<StudentInSubject> students = new ArrayList<>();

    public SubjectStudent() {
    }

    public SubjectStudent(String subjectName, String numberOfStudents, String average) {
        this.subjectName = subjectName;
        this.numberOfStudents = numberOfStudents;
        this.average = average;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(String numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public List<StudentInSubject> getStudents() {
        return students;
    }

    public void setStudents(List<StudentInSubject> students) {
        this.students = students;
    }
}
