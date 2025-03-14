package de.telran.exception_20250314;

public class MainError {

    public static void main(String[] args) {
        System.out.println("--- Старт main");
        div(4,0);
        if(div1(4,0)) {
            System.out.println("Все успешно");
        }
        else {
            System.out.println("Error");
        }

        int res = div2(4,0);
        if(res!=Integer.MAX_VALUE) {
            System.out.println("Все успешно, res="+res);
        }
        else {
            System.out.println("Error");
        }

        System.out.println("resException = "+divException(4,2));

        int arg2 = -1;
        try {
            System.out.println("resException = "+divException(4,arg2));
        }
        catch (ArithmeticException ex) {
            System.out.println("Тело ошибки -> "+ex.toString());
            arg2++;
            System.out.println("resException = "+divException(4,arg2));
        }
        catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
            System.out.println("Тело ошибки -> "+ex.toString());
            // Выполняем альтернативную логику
        }

        System.out.println("--- Конец main");

    }

    public static void div(int arg1, int arg2) {
        if(arg2 != 0) {
            int res = arg1 / arg2;
            System.out.println(res);
        }
        else {
            System.out.println("arg2 == 0 - error!");
        }
    }

    public static boolean div1(int arg1, int arg2) {
        if(arg2 != 0) {
            int res = arg1 / arg2;
            System.out.println(res);
            return true;
        }
        else {
            System.out.println("arg2 == 0 - error!");
            return false;
        }
    }

    public static int div2(int arg1, int arg2) {
        int res;
        if(arg2 != 0) {
            res = arg1 / arg2;
        }
        else {
            return Integer.MAX_VALUE;
        }
        return res;
    }

    public static int divException(int arg1, int arg2) {
        System.out.println("Старт divException");
        if(arg2<0) { //ручная генерация Exception
            throw new IllegalArgumentException("arg2 не может быть отрицательным!");
        }
        int res;
        res = arg1 / arg2;
        System.out.println("Конец divException");
        return res;
    }
}


