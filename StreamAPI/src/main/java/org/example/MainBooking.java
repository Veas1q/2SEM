package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.BitSet;

public class MainBooking {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper =  new ObjectMapper();
        Bookings bookings = mapper.readValue(new File("C:\\Users\\Redmi\\IdeaProjects\\SecondSemestr\\bookings.json"), Bookings.class);
        fromMoscow(bookings);
    }

    public static void printCount(Bookings bookings){
        System.out.println(
                bookings.getBookings().stream().count()
        );
    }
    public static void printCountWomen(Bookings bookings) {
        System.out.println(
                bookings.getBookings().stream().filter(b -> b.getPerson().getGender() != null).filter(b -> b.getPerson().getGender().equals("Female")).count()
        );
    }
    public static void fromMoscow(Bookings bookings){
        System.out.println(
                bookings.getBookings().stream().filter( b -> b.getPerson().getFromcity().contains("Москва")).count()
        );
    }
}
