package Homework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Mnojestvo<Integer> p = new Mnojestvo<Integer>();
        p.add(1);
        p.add(3);
        p.add(6);
        p.add(1);
        p.add(3);
        p.remove(1);
        Integer a[] = p.getAll(new Integer[0]);
        for(Integer i: a){
            System.out.print(i + " ");
        }
        System.out.println();
        Person Ivan = new Person("Ivan", "Bondarenko", "Aleksandrovich", 18);
        Person Ivan2 = new Person("Ivan", "Bobrov", "Sergeevich", 17);
        Person Aleksandr = new Person("Aleksandr", "Isaev", "Alekseevich", 18);
        Mnojestvo<Person> p1 = new Mnojestvo<Person>();
        p1.add(Ivan);
        p1.add(Ivan2);
        p1.add(Aleksandr);
        Person aa[] = p1.getAll(new Person[0]);
        for(Person i: aa){
            System.out.println(i);
        }
        
    }
}
