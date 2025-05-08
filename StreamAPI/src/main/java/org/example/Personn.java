package org.example;

import java.util.Date;

public class Personn {
    private String name;
    private int age;
    private String gender;
    private String fromCity;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public Personn(String name, int age, String gender, String fromCity) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.fromCity = fromCity;
    }
}
