package de.telran.generic_20250311;

public class Printer {
    public void print(String[] items) {
        for (String item : items) {
            System.out.println(item);
        }
    }

    //перегрузка
    public void print(Integer[] items) {
        for (Integer item : items) {
            System.out.println(item);
        }
    }


    // Generic метод
    public <T> void printGeneric(T[] items) {
        for (T item : items) {
            System.out.print(item+", ");
        }
        System.out.println();
    }
}
