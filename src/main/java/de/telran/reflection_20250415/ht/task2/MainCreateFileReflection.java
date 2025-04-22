package de.telran.reflection_20250415.ht.task2;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;

public class MainCreateFileReflection {
    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        String str = "Я тестирую работу Reflection API при работе с NIO";
        saveStrToFile(str, "mystr.txt");
        saveStrToFileReflection(str, "mystr_reflection.txt");
    }

    static void saveStrToFile(String str, String nameFile) throws IOException {
        Path path = Path.of(nameFile);
        Files.writeString(path, str);
    }

    static void saveStrToFileReflection(String str, String nameFile) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        Path path = Path.of(nameFile);
//        Files.writeString(path, str);

        Class clazzPath = Path.class;
        Class clazzFiles = Files.class;

        Method methodPathOf = clazzPath.getMethod("of", String.class, String[].class);
        Path path = (Path)methodPathOf.invoke(clazzPath, nameFile, new String[0]);

        Method methodFilesWriteString = clazzFiles.getMethod("writeString", Path.class, CharSequence.class, OpenOption[].class);
        methodFilesWriteString.invoke(clazzFiles, path, str, new OpenOption[0]);
     }
}
