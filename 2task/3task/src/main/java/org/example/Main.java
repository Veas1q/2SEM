package org.example;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Treygol<String> s = new Treygol<>("1","2","3");
        System.out.println(s);
        s.add(1,"xs");
        System.out.println(s);
        System.out.println(s.getX(2));
        Treygol<Integer> ss = new Treygol<>(1, 2, 3);
        System.out.println(ss);
        ss.add(1,3214);

    }
}