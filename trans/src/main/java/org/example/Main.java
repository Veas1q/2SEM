package org.example;

import Homework.Mnojestvo;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws Exception {
        TransportService p = new TransportService("C:\\Users\\Redmi\\IdeaProjects\\SecondSemestr\\trans\\transport.csv");
        String sortRoute_ = "номеру маршрута-";
        List403U<Bus> busList = p.readAllBus(sortRoute_);
        TransportPrintService pp = new TransportPrintService();
        System.out.println("=========== Отсортированный по " + sortRoute_ + "   ====================");

        pp.printInfo(busList);
        Mnojestvo setCountRoute = new Mnojestvo();
        Mnojestvo setCountNumber = new Mnojestvo();
        Mnojestvo setRouteCountT = new Mnojestvo();
        for (int i = 0; i < busList.size()  ; i++) {
            setCountRoute.add(busList.get(i).routeNumber);

        }
        for (int i = 0; i < busList.size()  ; i++) {
            setCountNumber.add(busList.get(i).number);
        }
        System.out.println("=========== Количество различных маршрутов ====================");
        System.out.println(setCountRoute.size());
        System.out.println("=========== Количество различных транспортов  ====================");
        System.out.println(setCountNumber.size());
        System.out.println("====================================================================");
        for (int i = 0; i < setCountRoute.size() ; i++) {
            String u = (String) setCountRoute.getI(i);
            int countU = 0;
            for (int j = 0; j < busList.size(); j++) {
                if(u.equals(busList.get(j).getRouteNumber()))
                    countU++;
            }
            System.out.println("Номер маршрута: " + u + " количеств средств на нем: "+ countU);
        }



    }

}