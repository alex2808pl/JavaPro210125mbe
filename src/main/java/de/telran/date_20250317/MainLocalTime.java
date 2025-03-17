package de.telran.date_20250317;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class MainLocalTime {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println("Текущее время = "+ localTime);

        LocalTime time = LocalTime.of(10, 30);
        System.out.println("Любое время = "+ time);

        LocalTime time1 = LocalTime.ofSecondOfDay(10_000);
        System.out.println("Любое время = "+ time1);

        // Получение элементов
        LocalTime now = LocalTime.now();
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        System.out.println(now.getNano());

        //Изменение
        LocalTime time2 = localTime.plusHours(2);
        LocalTime time3 = localTime.minusMinutes(40);
        LocalTime time4 = localTime.plusSeconds(3600);
        LocalTime time5 = localTime.plus(3600, ChronoUnit.MICROS);

        System.out.println(localTime);
        System.out.println(time2);
        System.out.println(time3);
        System.out.println(time4);

        // Разница
        Duration duration = Duration.between(time1, time); // по времени
        System.out.println(duration.toHoursPart() + " hours " +
                duration.toMinutesPart() + " minutes " +
                duration.toSecondsPart() + " seconds.");
    }
}
