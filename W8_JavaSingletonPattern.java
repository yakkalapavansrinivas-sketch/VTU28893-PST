class Singleton {

    public String str;

    private static Singleton singleInstance = new Singleton();

    private Singleton() {
    }

    public static Singleton getSingleInstance() {
        return singleInstance;
    }
}
