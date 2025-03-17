package de.telran.date_20250317;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class MainZoneDateTime {
    public static void main(String[] args) {
        ZonedDateTime zone = ZonedDateTime.now();
        System.out.println(zone);

        String text = "2022-12-20T00:35:47.023323700+02:00[Europe/Helsinki]";
        zone = ZonedDateTime.parse(text); // создание с текстового представления
        System.out.println(zone);

        //Ручное создание
        LocalDate date = LocalDate.now(); // дата

        // getting current time
        LocalTime time = LocalTime.now(); //время

        // getting system default zone id
        ZoneId zoneId = ZoneId.systemDefault(); //текущая зона на компьютере

        // creating a new ZonedDateTime object
        ZonedDateTime zoneDateTime = ZonedDateTime.of(date, time, zoneId);
        System.out.println(zoneDateTime);

        zoneId = ZoneId.of("Australia/Lindeman"); //менять зона и вычислять текущее время в Австралии
        zoneDateTime =  ZonedDateTime.now(zoneId);
        System.out.println(zoneDateTime);

        Set<String> zones = ZoneId.getAvailableZoneIds();
        System.out.println("count = "+zones.size());

        zoneDateTime =  ZonedDateTime.now(ZoneId.of("Indian/Cocos")); // смещение по минутам
        System.out.println(zoneDateTime);

        //zones.forEach(System.out::println);
    }
}
