package com.tvz.karlokovac.eteacher;

public class Student {

    private final String name;
    private final String age;
    private final String average;

    public Student() {
        this.name = "Test";
        this.age = "10";
        this.average = "4.5";
    }

    public Student(String name, String age, String average) {
        this.name = name;
        this.age = age;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getAverage() {
        return average;
    }
}
