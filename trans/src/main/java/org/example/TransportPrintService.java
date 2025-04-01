package org.example;

public class TransportPrintService {
    public void printInfo(List403U<? extends Transport> l){
        for (int i = 0; i < l.size(); i++) {
            System.out.println("Номер транспорта: " +  l.get(i).getNumber() + "| Номер маршрута: " + l.get(i).getRouteNumber() + " | Время начала: "
                    + l.get(i).getWorkTimeBegin() + " | Время конца: " + l.get(i).getWorkTimeEnd());
        }
    }
}

