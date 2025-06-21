public class Singleton {

    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton instance created.");
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        s1.showMessage();

        Singleton s2 = Singleton.getInstance();
        System.out.println("Are both instances same? " + (s1 == s2));
    }
}

    

