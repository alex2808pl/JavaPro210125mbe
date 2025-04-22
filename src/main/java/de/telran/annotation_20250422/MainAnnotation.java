package de.telran.annotation_20250422;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainAnnotation {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        UserClass userClass = new UserClass(100);
        userClass.sayHi();

        // Reflection класса
        System.out.println("-- Класс --");
        Class<UserClass> clazz = (Class<UserClass>) userClass.getClass();
        //Class<?> clazz1 = (Class<UserClass>) userClass.getClass();
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annot : annotations) {
            System.out.println("Annotation Type: " + annot.annotationType());
        }

        System.out.println("-- Методы --");
        Method m = clazz.getMethod("sayHi");
        annotations = m.getAnnotations();
        for (Annotation annot : annotations) {
            System.out.println("Annotation Methods: " + annot.annotationType());
        }

        System.out.println("-- Конструкторы --");
        Constructor c = clazz.getConstructor(int.class); //конструктор с одним аргументом
        annotations = c.getAnnotations();
        for (Annotation annot : annotations) {
            System.out.println("Annotation Constructors: " + annot.annotationType());
        }
        c = clazz.getConstructor(); // найдет конструктор по умолчанию

        System.out.println("-- Поля --");
        Field f = clazz.getDeclaredField("priv");
        annotations = f.getAnnotations();
        for (Annotation annot : annotations) {
            System.out.println("Annotation Fields: " + annot.annotationType());
        }
        UserAnnotation userAnnotation = f.getAnnotation(UserAnnotation.class);
        System.out.println("Value = "+userAnnotation.value());
        System.out.println("Number = "+userAnnotation.number());


    }
}
