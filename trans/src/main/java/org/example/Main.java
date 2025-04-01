package org.example;

import Homework.Mnojestvo;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws Exception {
        TransportService p = new TransportService("C:\\Users\\Redmi\\IdeaProjects\\SecondSemestr\\trans\\transport.csv");
        String sortRoute_ = "номеру маршрута-";
        List403U<Tram> busList = p.readAllTram();
        TransportPrintService pp = new TransportPrintService();
        List403U<Transport> transportList403U = p.readAll();
        TransportPrintService allTransport = new TransportPrintService();
        pp.printEnd(busList);

        Mnojestvo setCountRoute = new Mnojestvo();
        Mnojestvo setCountNumber = new Mnojestvo();
        Mnojestvo setRouteCountT = new Mnojestvo();
        for (int i = 0; i < transportList403U.size()  ; i++) {
            setCountRoute.add(transportList403U.get(i).routeNumber);

        }
        for (int i = 0; i < transportList403U.size()  ; i++) {
            setCountNumber.add(transportList403U.get(i).number);
        }
        System.out.println("=========== Количество различных маршрутов ====================");
        System.out.println(setCountRoute.size());
        System.out.println("=========== Количество различных транспортов  ====================");
        System.out.println(setCountNumber.size());
        System.out.println("====================================================================");
        for (int i = 0; i < setCountRoute.size() ; i++) {
            String u = (String) setCountRoute.getI(i);
            int countU = 0;
            for (int j = 0; j < transportList403U.size(); j++) {
                if(u.equals(transportList403U.get(j).getRouteNumber()))
                    countU++;
            }
            System.out.println("Номер маршрута: " + u + " количеств средств на нем: "+ countU);
        }



    }

}