package de.telran.reflection_20250415;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException, InstantiationException {
        // Создаем объект для последующей проверки свойств
        Sample sample = new Sample();

        Class cls = sample.getClass(); //возвращаем ссылку на Class из существующего конкретного объект

        var cls1 = sample.getClass(); //альтернативная возвращаем ссылку на Class из конкретного объект

        System.out.println("Имя класса (длинное) — " + cls.getName());
        System.out.println("Имя класса (короткое)— " + cls.getSimpleName());

        // Получаем имя конструктора класса с помощью объекта
        Constructor constructor = cls.getConstructor();
        System.out.println("Имя конструктора по умолчанию — " + constructor.getName());

        System.out.println("-------------");
        Constructor[] constructors = cls.getConstructors(); //только с public
        for (Constructor constr : constructors) {
            System.out.println("Имя конструктора — " + constr.getName());
        }

        System.out.println("-------------");
        constructors = cls.getDeclaredConstructors(); //все конструкторам, в т.ч. private
        for (Constructor constr : constructors) {
            System.out.println("Имя конструктора — " + constr.getName());
        }

        System.out.println("=== Методы ===");
        // Публичные методы, в т.ч. методы предков
        Method[] publicMethods = cls.getMethods();
        for (Method method : publicMethods) {
            System.out.println("public метод - "+method.getName());
        }
        System.out.println("-------------");
        // Все методы (не показывает методы предков)
        Method[] allMethods = cls.getDeclaredMethods();
        for (Method method : allMethods) {
            System.out.println(" метод - "+method.getName());
        }

        System.out.println("-------------");
        Method methPublic = cls.getMethod("methPublic");
        System.out.println("Нашли конкретный public метод по его имени - "+methPublic.getName());
        methPublic.invoke(sample); //запускаем метод

        System.out.println("-----Работа с перегруженным методом --------");
        methPublic = cls.getMethod("methPublic", int.class); // ищу methPublic(int)
        System.out.println("Нашли конкретный public метод по его имени и аргументу- "+methPublic.getName());
        methPublic.invoke(sample, 20); //запускаем метод и передаю значение аргумента

        System.out.println("-----Вызываем private метод через рефлекцию --------");
        Method meth = cls.getDeclaredMethod("methPrivate"); //приватный
        meth.setAccessible(true); //просим доступ для private
        meth.invoke(sample); //запускаем метод

        System.out.println("-----Вызываем protected метод через рефлекцию --------");
        // Вызываем метод с параметрами через рефлекцию
        meth = cls.getDeclaredMethod("methProtected", int.class);
        meth.invoke(sample, 25);

        System.out.println("-----Вызываем default метод c 2мя параметрами --------");
        meth = cls.getDeclaredMethod("methDefault", int.class, double.class);
        meth.invoke(sample, 25, 13.01);

        System.out.println("=== Поля (характеристики) ===");
        Field[] fields = cls.getFields(); // только public
        for (Field f : fields) {
            System.out.println(f.getName());
        }

        System.out.println("--- Все характеристики --- ");
        fields = cls.getDeclaredFields(); //все характеристики
        for (Field f : fields) {
            System.out.println(f.getName());
        }

        System.out.println("--- Изменения характеристик --- ");
        Field field = cls.getDeclaredField("priv"); //ищем по имени поля
        field.setAccessible(true); //открываем доступ
        System.out.println(field.getName()+" = "+field.get(sample));
        field.set(sample, "Я исправленный через рефлексию private");
        System.out.println(field.getName()+" = "+field.get(sample));
        field.setAccessible(false); //закрываем доступ

        System.out.println("=== Создание объекта класса c помощью Reflection === ");
        Class clazz = Class.forName(Sample.class.getName());  //получаем ссылку на Class по имени
        // clazz = Class.forName("Sample");  //аналог, получаем ссылку на Class по имени

        //Создаю новый объект, вызывая конструктор по умолчанию
        Sample sampleRefl = (Sample) clazz.getConstructor().newInstance(); // конструктор по умолчанию
        System.out.println("Старый объект ->"+sample);
        System.out.println("Новый объект, созданный через Reflection ->"+sampleRefl);
        sampleRefl.methPublic(); //вызываю метод из нового объекта

        //Вызываю static метод
        meth = clazz.getDeclaredMethod("methPublicStatic");
        meth.invoke(clazz); // можно передавать не объект, а сам объект типа Class

        System.out.println("--- Создаем объект, используем private конструктор с параметрами --- ");
        //Используем private конструктор с параметрами
        Class strClass = String.class; //еще одна возможность вернуть ссылку на объект Class
        Class[] params = {strClass, String.class}; // массив из 2х объектов Class, которые ссылаются на String
        constructor = clazz.getDeclaredConstructor(params); //найди все конструкторы, у которых 2 параметра String
        constructor.setAccessible(true);
        sampleRefl = (Sample) constructor.newInstance("arg1", "arg2");
        System.out.println("У нового объекта, созданного через private конструктор -> prot="+sampleRefl.prot);

        sampleRefl.methProtected(33);

    }
}
