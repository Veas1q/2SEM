package org.example;

public class Main {
    public static void main(String[] args) {
        LinkedList<Object> s = new LinkedList<Object>();

        s.addLast("1");
        s.addLast("2");
        s.addLast("3");
        s.addLast("4");
        s.addIn("9",1);
        s.print();

    }
}