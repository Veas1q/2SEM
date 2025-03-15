package org.example;

public class TestObject {
    public static void main(String[] args) {
        addTest();
    }

    public static void addTest() {
        List403ImplU<Object> list = new List403ImplU<Object>();
        list.add("1");
        list.add(2);
        list.add('c');
        System.out.println(list);
//        System.out.println((int) (list.get(0)) + (int)(list.get(1)));
    }
}
