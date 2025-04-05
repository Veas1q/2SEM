package org.example;

public class Main {
    public static void main(String[] args) {
        Map403<Integer, String> map = new MapImpl<>();
        map.put(1,"hi");
        map.put(2, "group");
        map.put(3, "11-403");
        map.put(1, "bye");
        System.out.println(map.containsValue("group"));
//        System.out.println(map.size());
//        System.out.println(map.get(1));
//        System.out.println(map.get(2));
//        System.out.println(map.get(3));

    }
}