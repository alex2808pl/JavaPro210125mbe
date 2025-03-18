package de.telran.regex_20250318;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class MainRegEx {
    public static void main(String[] args) {
        String regEx1 = "www.*";
        String str = "www.telran.de, www.google.com";

        // Лучше использовать для многократного поиска
        Pattern pattern = Pattern.compile(regEx1); //компиляция
        Matcher matcher = pattern.matcher(str); // начинаем поиск
        System.out.println("www -> "+matcher.matches()); // было ли найдено

        System.out.println("www -> "+matcher.start()+" -- "+matcher.end()); //начало и конец в строке

        Matcher matcher2 = pattern.matcher("www.i.ua"); // начинаем поиск
        System.out.println("Другой поиск www -> "+matcher.matches()); // было ли найдено

        System.out.println("Зй вариант поиска www -> "+pattern.matcher("www.rdt.de").matches()); // было ли найдено

        // Быстрый однократный поиск (компилируется постоянно)
        System.out.println("Быстрый однократный поиск 1 ->"+Pattern.matches("www.*", "www"));
        System.out.println("Быстрый однократный поиск 2 ->"+Pattern.matches("^[wW]{3}.+", "www.rdt.de"));

        // Разделение текста на слова
        String text = "I1learned2about3Telran4College5and6now7I'm8studying9Java";
        String delimiter = "\\d";

        // через Pattern
        pattern = Pattern.compile(delimiter, Pattern.CASE_INSENSITIVE);
        String[] result = pattern.split(text);
        System.out.println("через Pattern");
        for (String val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
        // Через String
        String[] resultStr = text.split(delimiter);
        System.out.println("через String");
        for (String val : resultStr) {
            System.out.print(val + " ");
        }
        System.out.println();

        //text = "I learned about Telran College,and now I'm studying Java";
        text = "Мама,мыла раму.Мокрой тряпкой?";
        delimiter = "[ ,.?!]"; //на слова (в т.ч. и с русскими буквами)
        //delimiter = "\\W"; //только в текстах с латинскими буквами [A-Za-z]
        resultStr = text.split(delimiter);
        System.out.println("через String");
        for (String val : resultStr) {
            System.out.print(val + "_");
        }
        System.out.println();


        // Литеральные строки
        findByPattern("apple", "applet, crabapple");

        // Метасимволы
        findByPattern(".ox", "The quick brown fox jumps over the lazy ox.");

        // Метасимволы (экранирование)
        findByPattern("\\.", "The quick brown fox jumps over the lazy ox.");

        // Классы символов
        findByPattern("[csw]", "cave");

        // Инвертирование Классы символов
        findByPattern("[^csvw]", "cave");

        //Интервал
        findByPattern("[a-c]", "cave");

        //Слияние диапазонов
        findByPattern("[a-cA-F]", "cavE");

        //Стандартные классы
        findByPattern("\\w", "aZ.8 _"); //могут быть в словах

        findByPattern("\\W", "aZ.8 _"); //не могут быть в словах

        //Граничные сопоставители
        findByPattern("^The\\w*", "Therefore");
        findByPattern("^The\\w*!$", "Therefore!");



    }

    private static void findByPattern(String pattern, String source) {
        System.out.println();
        try
        {
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(source);
            while (m.find()) {
                System.out.println("Found [" + m.group() + "] starting at "
                    + m.start() + " and ending at " + (m.end() - 1));
            }
        }
        catch (PatternSyntaxException pse)
        {
            System.err.println("Неправильное регулярное выражение: " + pse.getMessage());
            System.err.println("Описание: " + pse.getDescription());
            System.err.println("Позиция: " + pse.getIndex());
            System.err.println("Неправильный шаблон: " + pse.getPattern());
        }
    }

}
