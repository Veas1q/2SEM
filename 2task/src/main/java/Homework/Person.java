package Homework;

public class Person {
    private int age;
    private String name;
    private String secondName;
    private String lastName;

    public Person(String name, String secondName, String lastName, int age){
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if ( obj == null){
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Person p = (Person) obj;
        return p.name == this.name;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
