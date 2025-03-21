package de.telran.io_20250321;

import java.io.File;
import java.io.IOException;

public class MainSystemFileIO {
    public static void main(String[] args) throws IOException {
        // d:/java/my/file.txt - полный путь
        // ./file.txt - относительный путь
        File file = new File("./file.txt");

        //проверка существование
        boolean isExists = file.exists();
        System.out.println("file exists -> " + isExists);

        // создание файла на диске
        boolean wasCreatedFile = file.createNewFile();
        System.out.println("created file -> " + wasCreatedFile);

        // Размер файла
        long length = file.length();
        System.out.println("size file -> " +length);

        // Удаление файла c диска
        boolean success = file.delete();
        System.out.println("delete file -> "+success);

        // ==== Работа с папками ====

        // создание
        File dir = new File("new_dir"); // в текущем директории
        if(!dir.exists()) {
            System.out.println("Created new dir -> "+dir.mkdir());
        }

        File inFile = new File(dir, "newFile.txt"); // создать файл в директории
        if(!inFile.exists()) {
            System.out.println("created file " + inFile.createNewFile());
        }

        // Проверка на папку
        System.out.println("Is Folder -> "+dir.isDirectory()); //это папка
        System.out.println("Is not Folder -> "+inFile.isDirectory()); //это файл

        // Удаление вложенных объектов в папке (папка удаляется только пустая)
        File[] files = dir.listFiles(); // возвращает вложенные папки и файлы
        for (File fileDel : files) {
            // Проверка
            System.out.println("Is File -> "+fileDel.isFile()); //проверка на файл
            //удаление вложенного файла
            success = fileDel.delete();
            System.out.println("delete "+fileDel.getName()+" -> "+success);
        }
    }
}
