package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Personn[] p = {new Personn("Ivan", 10, "Male", "Moscow"), new Personn("Andrey", 12, "Female", "Alekseevsk"),
                new Personn("Artem", 12, "Male", "Almetevsk")
        };
//        List<String> names = Arrays.asList("Anna", "Ivan", "Maria", "Peter", "Alex", "John", "Olga");
//        names.stream().filter(z -> z.charAt(0) == 'A').toList().forEach(System.out::println);
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//        numbers.stream().map(x -> x*2).toList().forEach(System.out::println);
        List<String> words = Arrays.asList("Java", "Python", "C++", "Kotlin", "JavaScript");
        words.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
//        List<String> fruits = Arrays.asList("Apple", "Banana", "Avocado", "Apricot", "Cherry", "Blueberry");
//        fruits.stream().collect(Collectors.groupingBy(z -> z.charAt(0))).entrySet().forEach(System.out::println);
//        Arrays.stream(p).map(z -> z.getAge()).collect(Collectors.toSet()).forEach(System.out::println);
//        Arrays.stream(p).map(z -> z.getAge()).distinct().forEach(System.out::println);
//        Arrays.stream(p).collect(Collectors.groupingBy(Personn::getAge, Collectors.mapping(z -> z.getName(), Collectors.toSet()))).entrySet().forEach(System.out::println);
//        Arrays.stream(p).collect(Collectors.groupingBy(Personn::getAge, Collectors.mapping(z -> z.getName() + " " + z.getFromCity(), Collectors.toList()))).entrySet().forEach(System.out::println);


        record Pperson(String name, int age) {}
        List<Pperson> people = Arrays.asList(
                new Pperson("Alice", 25),
                new Pperson("Bob", 30),
                new Pperson("Charlie", 20),
                new Pperson("David", 35)
        );
        people.stream().filter(z -> z.age() > 25).map(z -> z.name()).sorted(Comparator.comparing(String::length)).forEach(System.out::println);

    }


}
