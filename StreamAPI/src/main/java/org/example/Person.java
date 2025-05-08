package org.example;

import java.util.Date;

public class Person {
    private String gender;
    private Date birthdate;
    private String fromcity;
    private String genderBirthday;
    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getFromcity() {
        return fromcity;
    }

    public void setFromcity(String fromcity) {
        this.fromcity = fromcity;
    }
    public String toString(){
        return birthdate + "";
    }
    public String getGenderBirthday(){
        if (getGender() != null && getBirthdate() != null){
            return (String)getGender() + getBirthdate();
        }
        return null;
    }
}
