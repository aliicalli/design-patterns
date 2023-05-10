package creational.singleton.multithread;

import java.util.Objects;

public final class MultiThreadSingleton {
    private static MultiThreadSingleton instance;
    public String value;

    private MultiThreadSingleton(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;
    }

    public static MultiThreadSingleton getInstance(String value) {
        if (Objects.isNull(instance)) {
            instance = new MultiThreadSingleton(value);
        }
        return instance;
    }
}
