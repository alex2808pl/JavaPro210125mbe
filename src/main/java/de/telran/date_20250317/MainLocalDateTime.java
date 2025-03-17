package de.telran.date_20250317;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class MainLocalDateTime {
    public static void main(String[] args) {
        // текущее время
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        // конкретная дата и время (месяц считается с 1)
        LocalDateTime localDateTime1 = LocalDateTime.of(2025, 3, 17, 11, 49, 30);
        System.out.println(localDateTime1);

        // конкретная дата и время (месяц считается с 1)
        LocalDateTime localDateTime2 = LocalDateTime.of(2025, Month.MARCH, 17, 11, 49, 30);
        System.out.println(localDateTime2);

        // конкретная дата и время
        LocalDate localDate1 = LocalDate.of(2025,02,12);
        LocalTime localTime1 = LocalTime.of(11,34,45,56743);
        LocalDateTime localDateTime5 = LocalDateTime.of(localDate1, localTime1);
        System.out.println("LocalDate + LocalTime = LocalDateTime -> "+localDateTime5);


        // получение элементов из даты
        int year = now.getYear();
        int month = now.getMonthValue(); //1...12
        System.out.println(month);
        Month monthEnum = now.getMonth(); // enum
        System.out.println(monthEnum);

        int dayOfMonth = now.getDayOfMonth(); // номер дня в неделе
        DayOfWeek dayOfWeek = now.getDayOfWeek(); // день недели как элемент перечисления
        System.out.println(now);
        System.out.println(dayOfWeek);
        System.out.printf("Шаблон даты = %d.%d.%d %d:%d \n", dayOfMonth, month, year, now.getHour(), now.getMinute()); //шаблонизированный вывод в консоль

        System.out.println();

        // добавление или удаление любого элемента даты и времени
        localDateTime1 = localDateTime1.minusMonths(10);
        localDateTime1 = localDateTime1.minusDays(3);
        localDateTime1 = localDateTime1.plusMinutes(10);
        localDateTime1 = localDateTime1.minus(5, ChronoUnit.DAYS);
        System.out.println("Дата после изменения = "+localDateTime1);

        // Adding 1 year, 1 month, 1 week and 1 day (паттерн Builder)
        LocalDateTime localDateTime3 =
                now
                .plusYears(1)
                .plusMonths(1)
                .plusWeeks(1)
                .plusDays(1);


        // сравнение даты
        System.out.println("isAfter = "+localDateTime1.isAfter(localDateTime2));
        System.out.println("isBefore = "+localDateTime1.isBefore(localDateTime2));
        System.out.println("equals = "+localDateTime1.equals(localDateTime2));
        System.out.println("== "+(localDateTime1 == localDateTime2));

        // Разница между датами
        LocalDateTime toDateTime = LocalDateTime.of(2014, 9, 9, 19, 46, 45);
        LocalDateTime fromDateTime = LocalDateTime.of(1984, 12, 16, 7, 45, 55);

        Period period = Period.between(fromDateTime.toLocalDate(), toDateTime.toLocalDate()); // из даты
        Duration duration = Duration.between(fromDateTime.toLocalTime(), toDateTime.toLocalTime()); // по времени

        System.out.println(period.getYears() + " years " +
                period.getMonths() + " months " +
                period.getDays() + " days " +
                duration.toHoursPart() + " hours " +
                duration.toMinutesPart() + " minutes " +
                duration.toSecondsPart() + " seconds.");

        // вывод в строку используя форматтер
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss a");

        // Formatting LocalDateTime to string
        String dateTimeString = localDateTime1.format(formatter);

        System.out.println(dateTimeString);

        //Локализация
        Locale locale = new Locale("uk");
        formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss.SSS", locale);
        System.out.println("Uk -> "+ localDateTime1.format(formatter));

    }
}
