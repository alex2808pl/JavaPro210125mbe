package de.telran.exception_20250314;

public class MainException {
    public static void main(String[] args) {
        int res = divException(4,4);
        System.out.println(res);

        res = divCheckException(4,2);
        System.out.println(res);

        try {
            res = divThrowsCheckException(4,1);
            System.out.println(res);
        } catch (InterruptedException e) {
            System.out.println("(main)Что то прошло при остановке программы!");
            //throw new RuntimeException(e);
        }

        // Пользовательское не отслеживаемое исключение
        try {
            getUserUncheck(-10);
        } catch (UserUncheckedException e) {
            System.out.println("Сиди дома, на улице мороз");
        }

        // Пользовательское отслеживаемое исключение
        try {
            getUserCheck(-10);
            System.out.println("Вставай, пора в школу");
        } catch (UserCheckedException e) {
            System.out.println("Сиди дома, на улице мороз");
        }
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

    public static int divCheckException(int arg1, int arg2) {
        System.out.println("Старт divCheckException");
        try {
            Thread.sleep(1000); // остановить выполнение нашей программы на 1 сек
        } catch (InterruptedException e) {
            System.out.println("Что то прошло при остановке программы!");
            //throw new RuntimeException(e);
        }
        if(arg2<0) { //ручная генерация Exception
            throw new IllegalArgumentException("arg2 не может быть отрицательным!");
        }
        int res;
        res = arg1 / arg2;
        System.out.println("Конец divCheckException");
        return res;
    }

    public static int divThrowsCheckException(int arg1, int arg2) throws InterruptedException{
        System.out.println("Старт divThrowsCheckException");
        Thread.sleep(1000); // остановить выполнение нашей программы на 1 сек
        if(arg2<0) { //ручная генерация Exception
            throw new IllegalArgumentException("arg2 не может быть отрицательным!");
        }
        int res;
        res = arg1 / arg2;
        System.out.println("Конец divThrowsCheckException");
        return res;
    }

    public static void getUserUncheck(int arg) {
        if(arg<0) {
            throw new UserUncheckedException("На улице мороз, в школу идти нельзя! ");
        }
    }

    public static void getUserCheck(int arg) throws UserCheckedException {
        if(arg<0) {
            throw new UserCheckedException("На улице мороз, в школу идти нельзя! ");
        }
    }
}
