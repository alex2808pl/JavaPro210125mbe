package de.telran.annotation_20250422;

@Deprecated
@UserAnnotation(value = "класс",number = 1)
public class UserClass {
    @UserAnnotation(value = "переменная класса", number = 2)
    private int priv;

    // @UserAnnotation - к конструктору применить не можем, т.к. в описании аннотации отсутствует ElementType.CONSTRUCTOR
    public UserClass(@UserAnnotation("параметр") int priv) {
        this.priv = priv;
    }

    public UserClass() {

    }

    @UserAnnotation("метод")
    public void sayHi() {
        System.out.println("Hi -> " + priv);
    }
}
