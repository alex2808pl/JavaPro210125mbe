package de.telran.generic;

public class MainPrinter {
    public static void main(String[] args) {
        Printer printer = new Printer();
        String[] coworkers = {"Вася", "Петя", "Дуня"};
        printer.print(coworkers);
        Integer[] salaries = {1000, 2000, 1500};
        printer.print(salaries);

        printer.printGeneric(coworkers);
        printer.printGeneric(salaries);
        Double[] constructions = {1.0,3.3,4.8};
        printer.<Double>printGeneric(constructions); // старый формат
    }
}
