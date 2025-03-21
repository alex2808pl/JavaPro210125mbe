package de.telran.io_20250321;

import java.io.*;

public class MainFileIO {
    public static void main(String[] args) {
        String nameFile = "testFile.txt";
        File testFile = new File(nameFile);

        // запись в файл
        OutputStream streamOut = null;
        try {
            if (!testFile.exists()) {
                if (testFile.createNewFile()) { //создаем файл
                    streamOut = new FileOutputStream(testFile); //открываю OutputStream
                    String str = "This string I can output to file";
                    byte[] output = str.getBytes();
                    streamOut.write(output);
                }
            }
        } catch (IOException ex) {
            System.err.println("Возникла ошибка записи информации в файл -> "+nameFile);
            System.err.println(ex.getMessage());
        } finally { // выполняется всегда, была ли ошибка или нет
                if(streamOut!=null) {
                    try {
                        streamOut.close(); //после использования нужно обязательно закрыть
                    } catch (IOException ex) {
                        System.err.println("Возникла ошибка при закрытии потока -> "+nameFile);
                        System.err.println(ex.getMessage());
                    }
                }

        }

        // читаем из файла
        try (InputStream streamIn = new FileInputStream(testFile);
             Reader reader = new InputStreamReader(streamIn)) { // try c ресурсами
            StringBuilder inStr = new StringBuilder(); // накапливать в строку полученную информацию из файла
            int data = reader.read(); //вычитываем числовое значение символа в формате Unicode
            while (data != -1) { // пока не конец файла
                inStr.append((char)data); //явное преобразование в символ
                System.out.print((char)data);
                data = reader.read(); //вычитываем символ в Unicode
            }
            System.out.println();
            System.out.println("Input from file -> "+inStr);

            // будут выполнены автоматически, т.к. мы используем try c ресурсами
//            streamIn.close();
//            reader.close();
        } catch (FileNotFoundException e) {//не найден файл
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
