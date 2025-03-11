package de.telran.generic;

public class Calculate {
    public static void main(String[] args) {
        System.out.println("Int + Int = "+add(5,2));
        System.out.println("Int + Double = "+add(5,2.0));

    }
    public static int add(int a1, int a2) {
        System.out.println("Int + Int");
        return a1+a2;
    }

    public static double add(int a1, double a2) {
        System.out.println("Int + Double");
        return a1+a2;
    }
}
