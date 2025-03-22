package Homework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Mnojestvo<Object> p = new Mnojestvo<Object>();
        p.add(1);
        p.add("2");
        p.add(23);
        p.add(true);
        p.add('h');
        p.add(1);
        System.out.println(p.remove(1));
        System.out.println(p.get(0));
//        p.getAll();
//        System.out.println(Arrays.toString(p.getAll()));
        Person Ivan = new Person("Ivan", "Bondarenko", "Aleksandrovich", 18);
        Person Ivan2 = new Person("Ivan", "Bobrov", "Sergeevich", 17);
        Person Aleksandr = new Person("Aleksandr", "Isaev", "Alekseevich", 18);
        Mnojestvo<Person> p1 = new Mnojestvo<Person>();
        p1.add(Ivan);
        p1.add(Ivan2);
        p1.add(Aleksandr);
        System.out.println(p1.size());
        System.out.println(p1.get(0).equals(p1.get(1)));
        System.out.println(p1.get(1).equals(p1.get(2)));
        System.out.println(p1.get(0).equals(p1.get(2)));
        
    }
}
