package de.telran.date_20250317;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class MainLocalDate {
    public static void main(String[] args) {
        // Создание объекта
        LocalDate date = LocalDate.now(); //текущая дата
        System.out.println(date);

        LocalDate date1 = LocalDate.of(2024, Month.MARCH, 27);
        System.out.println(date1);

        LocalDate date2 = LocalDate.of(2024, 10, 12);
        System.out.println(date2);

        // получение элементов из даты
        int year = date.getYear();
        int month = date.getMonthValue(); //1...12
        System.out.println(month);
        Month monthEnum = date.getMonth(); // enum
        System.out.println(monthEnum);

        int dayOfMonth = date.getDayOfMonth(); // номер дня в неделе
        DayOfWeek dayOfWeek = date.getDayOfWeek(); // день недели как элемент перечисления
        System.out.println(date);
        System.out.println(dayOfWeek);
        System.out.printf("Шаблон даты = %d.%d.%d \n", dayOfMonth, month, year);

        System.out.println();
        // добавление или удаление любого элемента даты
        date1 = date1.plusYears(4);
        date1 = date1.plusMonths(3);
        date1 = date1.plusDays(14);
        System.out.println(date1);

        date1 = date1.minusMonths(10);
        date1 = date1.minusDays(3);
        date1 = date1.minus(5, ChronoUnit.DAYS);
        System.out.println(date1);

        // сравнение даты
        System.out.println("isAfter = "+date.isAfter(date1));
        System.out.println("isBefore = "+date.isBefore(date1));
        System.out.println("equals = "+date.equals(date1));
        System.out.println("compareTo = "+date.compareTo(date1));
        System.out.println("compareTo = "+date1.compareTo(date));
    }
}
