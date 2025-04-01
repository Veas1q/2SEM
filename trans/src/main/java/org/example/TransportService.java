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

//    public  List403U<T> sort( String b){
//        if (b.equals("номеру-")) {
//            for (int i = 0; i < resault.size(); i++) {
//                for (int j = 0; j < resault.size(); j++) {
//                    if (resault.get(i).getIntNumber() > resault.get(j).getIntNumber()) {
//                        resault.swap(i, j);
//                    }
//                }
//            }
//        } else if (b.equals("номеру+")) {
//            for (int i = 0; i < resault.size(); i++) {
//                for (int j = 0; j < resault.size(); j++) {
//                    if (resault.get(i).getIntNumber() < resault.get(j).getIntNumber()) {
//                        resault.swap(i, j);
//                    }
//                }
//            }
//        }else if (b.equals("времени начала-")) {
//            for (int i = 0; i < resault.size(); i++) {
//                for (int j = 0; j < resault.size(); j++) {
//                    if (resault.get(i).getIntWorkTimeBegin() > resault.get(j).getIntWorkTimeBegin()) {
//                        resault.swap(i, j);
//                    }
//                }
//            }
//        }else if (b.equals("времени начала+")) {
//            for (int i = 0; i < resault.size(); i++) {
//                for (int j = 0; j < resault.size(); j++) {
//                    if (resault.get(i).getIntWorkTimeBegin() < resault.get(j).getIntWorkTimeBegin()) {
//                        resault.swap(i, j);
//                    }
//                }
//            }
//        }else if (b.equals("времени конца-")) {
//            for (int i = 0; i < resault.size(); i++) {
//                for (int j = 0; j < resault.size(); j++) {
//                    if (resault.get(i).getIntWorkTimeEnd() > resault.get(j).getIntWorkTimeEnd()) {
//                        resault.swap(i, j);
//                    }
//                }
//            }
//        }else if (b.equals("времени конца+")) {
//            for (int i = 0; i < resault.size(); i++) {
//                for (int j = 0; j < resault.size(); j++) {
//                    if (resault.get(i).getIntWorkTimeEnd() < resault.get(j).getIntWorkTimeEnd()) {
//                        resault.swap(i, j);
//                    }
//                }
//            }
//        }
//        else if (b.equals("номеру маршрута-")) {
//            for (int i = 0; i < resault.size(); i++) {
//                for (int j = 0; j < resault.size(); j++) {
//                    if (resault.get(i).getIntRouteNumber() > resault.get(j).getIntRouteNumber()) {
//                        resault.swap(i, j);
//                    }
//                }
//            }
//        }else if (b.equals("номеру маршрута+")) {
//            for (int i = 0; i < resault.size(); i++) {
//                for (int j = 0; j < resault.size(); j++) {
//                    if (resault.get(i).getIntRouteNumber() < resault.get(j).getIntRouteNumber()) {
//                        resault.swap(i, j);
//                    }
//                }
//            }
//        }
//        return resault;
//    }

    public List403U<Transport> readAll (String b) throws FileNotFoundException {
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
        if (b.equals("номеру-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntNumber() > resault.get(j).getIntNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        } else if (b.equals("номеру+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntNumber() < resault.get(j).getIntNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени начала-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeBegin() > resault.get(j).getIntWorkTimeBegin()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени начала+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeBegin() < resault.get(j).getIntWorkTimeBegin()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени конца-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeEnd() > resault.get(j).getIntWorkTimeEnd()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени конца+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeEnd() < resault.get(j).getIntWorkTimeEnd()) {
                        resault.swap(i, j);
                    }
                }
            }
        }
        else if (b.equals("номеру маршрута-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntRouteNumber() > resault.get(j).getIntRouteNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("номеру маршрута+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntRouteNumber() < resault.get(j).getIntRouteNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        }
        s.close();
        return resault;
    }
    public List403U<Bus> readAllBus(String b) throws FileNotFoundException {
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
        if (b.equals("номеру-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntNumber() > resault.get(j).getIntNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        } else if (b.equals("номеру+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntNumber() < resault.get(j).getIntNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени начала-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeBegin() > resault.get(j).getIntWorkTimeBegin()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени начала+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeBegin() < resault.get(j).getIntWorkTimeBegin()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени конца-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeEnd() > resault.get(j).getIntWorkTimeEnd()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени конца+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeEnd() < resault.get(j).getIntWorkTimeEnd()) {
                        resault.swap(i, j);
                    }
                }
            }
        }
        else if (b.equals("номеру маршрута-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntRouteNumber() > resault.get(j).getIntRouteNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("номеру маршрута+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntRouteNumber() < resault.get(j).getIntRouteNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        }
        s.close();
        return resault;
    }
    public List403U<Tram> readAllTram (String b) throws FileNotFoundException {
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
        if (b.equals("номеру-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntNumber() > resault.get(j).getIntNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        } else if (b.equals("номеру+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntNumber() < resault.get(j).getIntNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени начала-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeBegin() > resault.get(j).getIntWorkTimeBegin()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени начала+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeBegin() < resault.get(j).getIntWorkTimeBegin()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени конца-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeEnd() > resault.get(j).getIntWorkTimeEnd()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени конца+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeEnd() < resault.get(j).getIntWorkTimeEnd()) {
                        resault.swap(i, j);
                    }
                }
            }
        }
        else if (b.equals("номеру маршрута-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntRouteNumber() > resault.get(j).getIntRouteNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("номеру маршрута+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntRouteNumber() < resault.get(j).getIntRouteNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        }

        s.close();
        return resault;
    }
    public List403U<Trolleybus> readAllTrolleybus (String b) throws FileNotFoundException {
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
        if (b.equals("номеру-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntNumber() > resault.get(j).getIntNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        } else if (b.equals("номеру+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntNumber() < resault.get(j).getIntNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени начала-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeBegin() > resault.get(j).getIntWorkTimeBegin()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени начала+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeBegin() < resault.get(j).getIntWorkTimeBegin()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени конца-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeEnd() > resault.get(j).getIntWorkTimeEnd()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("времени конца+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntWorkTimeEnd() < resault.get(j).getIntWorkTimeEnd()) {
                        resault.swap(i, j);
                    }
                }
            }
        }
        else if (b.equals("номеру маршрута-")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntRouteNumber() > resault.get(j).getIntRouteNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        }else if (b.equals("номеру маршрута+")) {
            for (int i = 0; i < resault.size(); i++) {
                for (int j = 0; j < resault.size(); j++) {
                    if (resault.get(i).getIntRouteNumber() < resault.get(j).getIntRouteNumber()) {
                        resault.swap(i, j);
                    }
                }
            }
        }
        s.close();
        return resault;
    }
}

