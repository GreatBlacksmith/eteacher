package com.tvz.karlokovac.eteacher.data;

public class TestStudent {

    private String studentName;
    private String score;
    private String comment;

    public TestStudent() {
    }

    public TestStudent(String studentName, String score, String comment) {
        this.studentName = studentName;
        this.score = score;
        this.comment = comment;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
