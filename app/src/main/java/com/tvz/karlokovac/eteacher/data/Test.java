package com.tvz.karlokovac.eteacher.data;

public class Test {
    private String testName;
    private String subjectName;
    private String numberOfParticipants;
    private String averageScore;

    public Test() {
    }

    public Test(String testName, String subjectName, String numberOfParticipants, String averageScore) {
        this.testName = testName;
        this.subjectName = subjectName;
        this.numberOfParticipants = numberOfParticipants;
        this.averageScore = averageScore;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(String numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(String averageScore) {
        this.averageScore = averageScore;
    }
}
