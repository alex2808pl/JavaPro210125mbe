package de.telran.nio_20250325;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class MainChannel {
    public static void main(String[] args) throws IOException {
        Path pathDefault = Paths.get("testChannelFile.txt");
        if(Files.notExists(pathDefault)) {
            pathDefault = Files.createFile(pathDefault);
        }
        String s = "I was here!";
        byte[] data = s.getBytes();

        ByteBuffer out = ByteBuffer.wrap(data); //создание буфера для конкретных данных

        ByteBuffer copy = ByteBuffer.allocate(12); //создание буфера строго заданного объема

        try (FileChannel fc = FileChannel.open(pathDefault, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
            int nread;
            do {
                nread = fc.read(copy);
            } while (nread != -1 && copy.hasRemaining());

            // Пишем "I was here!" в начало файла.
            fc.position(0); // в начало файла
            while (out.hasRemaining()) { // пока в этом буфере еще есть данные
                fc.write(out);
            }

            long length = fc.size(); //размер файла
            System.out.println("length = " + length);
            fc.position(length); //переходим в конец файла
            copy.flip(); //устанавливаем курсор в буфере на начало
            while (copy.hasRemaining()) {
                fc.write(copy);
            }
            // С буфера пишем в файл
            while (out.hasRemaining()) {
                fc.write(out);
            }
        }
    }
}
