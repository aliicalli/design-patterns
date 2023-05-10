package creational.singleton.singlethread;

import java.util.Objects;

public final class Singleton {

    private static Singleton instance;
    public String value;

    private Singleton(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (Objects.isNull(instance)) {
            instance = new Singleton(value);
        }
        return instance;
    }

}
