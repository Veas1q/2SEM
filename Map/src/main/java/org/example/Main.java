package org.example;

public class Main {
    public static void main(String[] args) {
        Map403<Integer, String> map = new MapImpl<>();
        map.put(1,"hi");
        map.put(2, "group");
        map.put(3, "11-403");
        map.put(1, "bye");
//        System.out.println(map.containsValue("group"));
//        System.out.println(map.size());
//        System.out.println(map.get(1));
//        System.out.println(map.get(2));
//        System.out.println(map.get(3));
        Map403<Integer, Integer> m = new MapImpl<>();
        m.put(1,4213);
        m.put(2,4324);
        m.put(3,99849);
        m.put(4,2132);
        List403U<String> dd = new List403ImplU<>();
        dd = m.map(p -> p + "$$$");
        for(String i : dd){
            System.out.println(i);;
        }

    }
}