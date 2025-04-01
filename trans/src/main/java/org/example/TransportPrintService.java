package org.example;
import java.util.Comparator;
public class TransportPrintService {
    public void printInfo(List403U<? extends Transport> l){
        for (int i = 0; i < l.size(); i++) {
            System.out.println("Номер транспорта: " +  l.get(i).getNumber() + "| Номер маршрута: " + l.get(i).getRouteNumber() + " | Время начала: "
                    + l.get(i).getWorkTimeBegin() + " | Время конца: " + l.get(i).getWorkTimeEnd());
        }
    }
    public <T extends Transport> void printParkNumber2(List403U<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(Transport o1, Transport o2) {
                return o1.getNumber().compareTo(o2.getNumber());
            }
        });

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNumber() + ", " +
                    list.get(i).getWorkTimeBegin());
        }
    }
    public <T extends Transport> void printStart(List403U<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(Transport o1, Transport o2) {
                return o1.getWorkTimeBegin().compareTo(o2.getWorkTimeBegin());
            }
        });

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNumber() + ", " +
                    list.get(i).getWorkTimeBegin());
        }
    }
    public <T extends Transport> void printEnd(List403U<T> list) {
        list.sort(new Comparator<T>() {
            @Override
            public int compare(Transport o1, Transport o2) {
                return o1.getWorkTimeEnd().compareTo(o2.getWorkTimeEnd());
            }
        });

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getNumber() + ", " +
                    list.get(i).getWorkTimeEnd());
        }
    }
}

