package de.telran.reflection_20250415;

public class Sample {
    public String publ;
    String def;
    private String priv;
    protected String prot;

    public Sample() {
        publ = "Я public";
        def = "Я default";
        priv = "Я private";
        prot = "Я protected";
    }

    public Sample(String priv) {
        this.priv = priv;
    }

    private Sample(String priv, String prot) {
        this.priv = priv;
        this.prot = prot;
    }

    //Публичный метод
    public void methPublic() {
        System.out.println("Я public метод");
    }

    //Публичный перегруженный метод
    public void methPublic(int x) {
        System.out.println("Я перегруженный public метод -> аргумент = "+x);
    }

    //Приватный метод
    private void methPrivate() {
        System.out.println("Я private метод");
    }

    //Protected метод
    protected void methProtected(int x) {
        System.out.println("Я protected метод -> "+x);
    }

    //Default метод
    void methDefault(int x, double y) {
        System.out.println("Я default метод -> сумма = "+(x+y));
    }

    //Публичный static метод
    public static void methPublicStatic() {
        System.out.println("Я public static метод");
    }
}
