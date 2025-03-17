package de.telran.date_20250317;

import java.time.Instant;

public class MainInstant {
    public static void main(String[] args) {
        // текущее дата и время
        Instant instant = Instant.now(); // используется как аналог Date (c 1/1/1970)
        System.out.println(instant);

        // создание отсчет с 1.1.1970
        System.out.println(Instant.ofEpochSecond(111111111L, 222222));

        long n = instant.toEpochMilli(); // получение милисекунд с даты
        Instant time = Instant.ofEpochMilli(n);
        System.out.println(time);

        // получение со строки
        Instant instant2 = Instant.parse("2025-03-17T11:45:31.550652200Z");
        System.out.println(instant2);

    }
}
