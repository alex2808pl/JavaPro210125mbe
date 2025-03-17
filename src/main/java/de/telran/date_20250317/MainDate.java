package de.telran.date_20250317;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainDate {
    public static void main(String[] args) {
        Date date1 = new Date();
        System.out.println("Текущая дата = "+date1);
        System.out.println("Текущая дата (long) = "+date1.getTime());

        Date date2 = new Date(3665467688799L);
        System.out.println("Наша дата = "+date2);

        //Не рекомендуется к использованию
        Date date3 = new Date(125, 1, 19); // месяц с 0, год - не понятный алгоритм
        System.out.println("Введенная дата = "+date3);

        // Сравнение
        System.out.println("Сравнение милисекунд = "+(date2.getTime() >= date1.getTime()));

        boolean fl = date1.after(date2); // date1 после date2
        System.out.println("after -> "+fl);

        fl = date1.before(date2); // date1 перед date2
        System.out.println("before -> "+fl);

        // Присвоение
        date3 = new Date(); // разные объекты в Heap
        date3.setTime(date1.getTime());

        date2.setTime(3665467688799L);  // милисекунды
        date2.setHours(12); //не рекомендуеться @Deprecated

        int compare = date1.compareTo(date2); // сравнения 2х дат
        System.out.println("compareTo ->"+compare); // компаринг

        System.out.println("Equals = "+ date1.equals(date3));
        System.out.println("== "+ (date1==date3)); //date1==date3

        Date date4 = date1; // один и тот же объект в Heap
        System.out.println("Equals = "+ date1.equals(date4));
        System.out.println("== "+ (date1==date4)); //date1==date4

        // Локализация
        Locale locale = new Locale("en"); //украинская локализация //de, ru, en
        Locale.setDefault(locale);
        Date now = new Date();
        System.out.println("Стандарт = "+now);
        // Используем стандарные форматеры
        String date = String.format(locale, "%tc\n", now) + // длинная строка
                String.format(locale, "%tD\n", now) + //(MM/DD/YY)
                String.format(locale, "%tF\n", now) + //(YYYY-MM-DD)
                String.format(locale, "%tr\n", now) + //Full 12-hour time
                String.format(locale, "%tz\n", now) + //Time zone GMT offset
                String.format(locale, "%tZ\n", now);//Localized time zone abbreviation
        System.out.println(date);

        //Преобразование в строку
        String pattern = "dd.MM.yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        System.out.println("Пользовательский формат -> "+df.format(now));

        //Макс Date
        Date dateMax = new Date(Long.MAX_VALUE);
        System.out.println("Max дата = " + dateMax);

    }
}
