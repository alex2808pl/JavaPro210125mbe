package de.telran.nio_20250325;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class MainFileNio {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("testRAF.txt");

        // == Короткие файлы ===
        // Чтение данных
        // со строками
        List<String> lists = Files.readAllLines(path);
        System.out.println(lists);
        System.out.println("=====");

        // читаю как байты
        byte[] bytes = Files.readAllBytes(path);
        System.out.println(new String(bytes));

        //Запись данных в файл
        Path pathNew = Files.write(Path.of("newBytes.txt"),bytes); // пишем байты
        pathNew = Files.write(Path.of("newList.txt"),lists); //пишем строки из листа


        //==== Возможная работа с большими файлами (сопряжение с IO)

        //Чтение частями
        List<String> stringList = new ArrayList<>();
        System.out.println("===== Как большие файлы === ");
        if (Files.exists(path)) {
            try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            ) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line); // вывожу на консоль вычитанную строку
                    stringList.add(line); // добавляем информацию в List
                }
            } catch (IOException e) {
                throw new RuntimeException(e); //преобразование отслеживаемого исключения IOException в неотслеживаемое
            }
        }

        // Запись частями
        Path pathCopyFile = Paths.get("testCopyFile.txt");

        try (BufferedWriter bufWriter = Files.newBufferedWriter(pathCopyFile, StandardCharsets.UTF_8,
                StandardOpenOption.CREATE, StandardOpenOption.WRITE/*,  StandardOpenOption.APPEND*/)) {
            for (String s : stringList) {
                bufWriter.write(s+"\n"); // записываю информацию в новый файл построчно из List
            }
         } catch (IOException e) {
            throw new RuntimeException(e); //преобразование отслеживаемого исключения IOException в неотслеживаемое
        }

    }
}
