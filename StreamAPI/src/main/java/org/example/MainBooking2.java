package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class MainBooking2{
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper =  new ObjectMapper();
        Bookings bookings = mapper.readValue(new File("C:\\Users\\Redmi\\IdeaProjects\\SecondSemestr\\bookings.json"), Bookings.class);
//        printFromSamara(bookings);
        printCountUP(bookings);
        System.out.println(printMapHotelCity(bookings));
//        Map<String, Set<String>> res = printMapHotelCity(bookings);
//        res.forEach((hotel, cities) ->
//                System.out.println(hotel + ": " + cities));
    }


    public static void printChild(Bookings bookings){
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd")
                    .parse("2011-04-23");
            bookings.getBookings()
                    .stream()
                    .filter(p -> p.getPerson().getBirthdate() != null)
                    .filter(p -> p.getPerson().getBirthdate().after(date))
                    .map(b -> b.getPerson()).toList().forEach(System.out::println);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public static void printHotel(Bookings bookings){
        Map<String, Integer> result =
        bookings.getBookings().stream().collect(Collectors.toMap(b -> b.getHotel().getName(), b -> 1, (x,y) -> x+y));
        result.entrySet()
                .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }
    public static void printWHotel(Bookings bookings){
        Map<String, Integer> resault = bookings.getBookings().stream().
                filter(p -> p.getPerson().getGender() != null)
                .filter(p -> p.getPerson().getGender().equals("Female"))
                .collect(Collectors.toMap(b -> b.getHotel().getName(), b -> 1, (x,y) -> x+y));
        resault.entrySet().forEach(e -> System.out.println("Отель: " + e.getKey() + " Женщин в отеле: " + e.getValue()));
    }

    public static void printMHotel(Bookings bookings){
        Map<String, Integer> result = bookings.getBookings().stream()
                .filter(p -> p.getPerson().getGender() != null)
                .filter(p -> p.getPerson().getGender().equals("Male"))
                .collect(Collectors.toMap(b -> b.getHotel().getName(), b -> 1, (x,y) -> x+y));
        result.entrySet().forEach(e -> System.out.println("Отель " + e.getKey() + " количество мужчин в нем: " + e.getValue()));
    }
    public static void printFromSamara(Bookings bookings){
        long fromSamar = bookings.getBookings().stream().filter(p -> p.getPerson().getFromcity().contains("Самарская область")).count();
        long allPerson = bookings.getBookings().stream().count();
        float percent = (float) fromSamar/allPerson * 100;
        System.out.println("Людей из Самарской области " + percent);
    }
    public static void printPeople40_45Years(Bookings bookings) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd")
                    .parse("1985-04-28");
            Date date1 = new SimpleDateFormat("yyyy-MM-dd")
                    .parse("1980-04-28");
            long count40plus = bookings.getBookings().stream().filter(p -> p.getPerson().getBirthdate() != null).filter(p -> p.getPerson().getBirthdate().before(date)).count();
            long count45plus = bookings.getBookings().stream().filter(p -> p.getPerson().getBirthdate() != null).filter(p -> p.getPerson().getBirthdate().before(date1)).count();
            System.out.println("Количество людей старше " + (count40plus - count45plus));

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
    public static void printCityCountHotel(Bookings bookings){
        Map<String, Integer> cityHotelCount = bookings.getBookings().stream()
                .filter(p -> p.getPerson() != null)
                .map(p -> p.getPerson().getFromcity())
                .filter(city -> city.matches(".*( г |город |Город ).*"))
                .map(city -> city.replaceAll(".*( г |город |Город )", "").split(",")[0])
                .collect(Collectors.toMap(
                        city -> city,
                        city -> 1,
                        (x,y) -> x+y));

        cityHotelCount.forEach((city, count) ->
                System.out.println(city + ": " + count + " отелей"));
    }

    public static Map<String, Set<String>> printMapHotelCity(Bookings bookings){
        Map <String, Set<String>> res = bookings.getBookings().stream()
                .collect(Collectors.groupingBy(p -> p.getHotel().getName(), Collectors.mapping(p -> p.getPerson().getFromcity(), Collectors.toSet())));
        return res;
    }
    public static void printCountUP(Bookings bookings){
        long all = bookings.getBookings().stream().count();
        Set<String> p = bookings.getBookings().stream().map(Booking::getPerson).filter(z -> z.getGenderBirthday() != null).map(Person::getGenderBirthday).collect(Collectors.toSet());
        System.out.println("Уникальных людей " + (float)p.size());
    }




}


