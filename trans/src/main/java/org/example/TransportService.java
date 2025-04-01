package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

public class TransportService {
    private File file;

    public TransportService(String file) {
        this.file = new File(file);
    }

    public List403U<Transport> readAll () throws FileNotFoundException {
        Scanner s = new Scanner(file);
        if (s.hasNextLine()){
            s.nextLine();
        }
        List403ImplU<Transport> resault = new List403ImplU<>();
        while (s.hasNextLine()){
            String line  = s.nextLine();
            String[] str = line.split(";");
            resault.add(
                    switch (str[0]){
                        case "bus" -> new Bus(str[1], str[2], str[3], str[4]);
                        case "trolleybus" -> new Trolleybus(str[1], str[2], str[3], str[4]);
                        case "tram" -> new Tram(str[1], str[2], str[3], str[4]);
                        default -> null;
                    }
            );
        }

        s.close();
        return resault;
    }
    public List403U<Bus> readAllBus() throws FileNotFoundException {
        Scanner s = new Scanner(file);
        if (s.hasNextLine()){
            s.nextLine();
        }
        List403ImplU<Bus> resault = new List403ImplU<>();
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] str = line.split(";");
            if (str[0].equals("bus")) {
                resault.add(new Bus(str[1], str[2], str[3], str[4]));
            }
        }

        s.close();
        return resault;
    }
    public List403U<Tram> readAllTram () throws FileNotFoundException {
        Scanner s = new Scanner(file);
        if (s.hasNextLine()){
            s.nextLine();
        }
        List403ImplU<Tram> resault = new List403ImplU<>();
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] str = line.split(";");
            if (str[0].equals("tram")) {
                resault.add(new Tram(str[1], str[2], str[3], str[4]));
            }
        }

        s.close();
        return resault;
    }
    public List403U<Trolleybus> readAllTrolleybus () throws FileNotFoundException {
        Scanner s = new Scanner(file);
        if (s.hasNextLine()){
            s.nextLine();
        }
        List403ImplU<Trolleybus> resault = new List403ImplU<>();
        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] str = line.split(";");
            if (str[0].equals("trolleybus")) {
                resault.add(new Trolleybus(str[1], str[2], str[3], str[4]));
            }
        }

        s.close();
        return resault;
    }
}

