package de.telran.io_20250321;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MainRandomAccessFile {
    // запись в файл
    public static void write(RandomAccessFile file, String path, String st) throws IOException {
        // открываем файл для записи
        // для этого указываем модификатор rw (read & write)
        // что позволит открыть файл и записать его
        file = new RandomAccessFile(path, "rw");

        // записываем строку переведенную в биты
        file.write(st.getBytes());

        // закрываем файл, после чего данные записываемые данные попадут в файл
        file.close();
    }

    public static void writeToPositionInFile(RandomAccessFile file, String path, String st, int num) throws IOException {
        // открываем файл для записи
        // для этого указываем модификатор rw (read & write)
        // что позволит открыть файл и записать его
        file = new RandomAccessFile(path, "rw");

        // переходим на num символ
        file.seek(num);

        // записываем строку переведенную в биты
        file.write(st.getBytes());

        // закрываем файл, после чего данные записываемые данные попадут в файл
        file.close();
    }


    // этот метод читает файл и выводит его содержимое
    public static String read(RandomAccessFile file, String path) throws IOException {
        file = new RandomAccessFile(path, "r");
        String res = "";
        int b = file.read();
        // побайтово читаем символы и плюсуем их в строку
        while(b != -1){
            res = res + (char)b;
            b = file.read();
        }
        file.close();

        return res;
    }

    // метод демонстрирует переход на указанный символ
    public static long goTo(RandomAccessFile file, String path, int num) throws IOException {
        // инициализируем класс RandomAccessFile
        // в параметры передаем путь к файлу
        // и модификатор который говорит, что файл откроется только для чтения
        file = new RandomAccessFile(path, "r");

        // переходим на num символ
        file.seek(num);

        // получаем текущее состояние курсора в файле (в какой позиции он находиться)
        long pointer = file.getFilePointer();
        file.close();

        return pointer;
    }

    // читаем файл с определенного символа
    public static String readFrom(RandomAccessFile file, String path, int numberSymbol) throws IOException {
        // открываем файл для чтения
        file = new RandomAccessFile(path, "r");
        String res = "";

        // ставим указатель на нужный вам символ
        file.seek(numberSymbol);

        int b = file.read();
        // побайтово читаем и добавляем символы в строку
        while(b != -1){
            res = res + (char)b;

            b = file.read();
        }
        file.close();

        return res;
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = null;
        String path = "testRAF.txt";

        // пишем передаваемый текст в файл
        write(file, path, "Give me a break from your take and your take. \n" +
                "Come on and give me a break,\n" +
                "what do you want from me?\n" +
                "Feeding the rich with that son of a bitch.\n" +
                "Well that son of a bitch,\n" +
                "he looks just like me!\n" +
                "Yeah, yeah");

        // читаем весь файл
        System.out.println(read(file, path));
        System.out.println("*******");

        // переходим на указанный символ в файле
        System.out.println("Позиция в файле -> " +goTo(file, path, 100));
        System.out.println("*******");

        // переходим на указанный символ в файле
        System.out.println("Читаем с 105 позиции в файле -> " +readFrom(file, path, 102));
        System.out.println("*******");

        //сохраняем в файл строку с нужной позиции внутри файла
        writeToPositionInFile(file, path, "!!!Text write to position!!! ", 102);
        // читаем весь файл
        System.out.println(read(file, path));
        System.out.println("*******");

    }
}
