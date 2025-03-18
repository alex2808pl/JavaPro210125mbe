package de.telran.regex_20250318;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainRegExGreedy {
    public static void main(String[] args) {
        String str = "Егор Анна А_а Александр";
        //String regEx = "А.+а"; //жадный (исп.по умолчанию)
        //String regEx = "А.+?а"; //ленивый
        String regEx = "А.*?а"; //ленивый
        // String regEx = "А.++а"; //сверхжадный (не вижу для него практических задач)
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println("Found [" + matcher.group() + "] starting at "
                    + matcher.start() + " and ending at " + (matcher.end() - 1));
        }
    }
}
