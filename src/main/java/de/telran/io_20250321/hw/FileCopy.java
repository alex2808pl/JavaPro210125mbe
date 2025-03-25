package de.telran.io_20250321.hw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем путь к существующему файлу
        System.out.print("Введите путь к существующему файлу: ");
        String sourceFilePath = scanner.nextLine();

        // Запрашиваем имя нового файла
        System.out.print("Введите имя нового файла: ");
        String destinationFilePath = scanner.nextLine();

        // Открываем файлы для копирования
        File sourceFile = new File(sourceFilePath);
        File destinationFile = new File(destinationFilePath);

        // Проверяем, существует ли исходный файл
        if (!sourceFile.exists()) {
            System.out.println("Файл " + sourceFilePath + " не существует.");
            return;
        }

        // Копируем содержимое
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int length;

            // Чтение и запись данных
//            while ((length = fis.read(buffer)) > 0) {
//                fos.write(buffer, 0, length);
//            }

            // 2 вариант кода выше (аналог)
            length = fis.read(buffer); //считали первую порцию информации
            while (length != -1) {
                fos.write(buffer, 0, length);  //записали в файл обьем полученный из источника
                length = fis.read(buffer); //считали следующая порцию информации
            }


            System.out.println("Файл успешно скопирован.");

        } catch (IOException e) {
            System.out.println("Произошла ошибка при копировании файла: " + e.getMessage());
        }
    }
}
