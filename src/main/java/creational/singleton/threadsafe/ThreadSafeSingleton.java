package creational.singleton.threadsafe;

import java.util.Objects;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;
    public String value;

    public ThreadSafeSingleton(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.value = value;

    }


    public static ThreadSafeSingleton getInstance(String value) {
        ThreadSafeSingleton result = instance;
        if (Objects.nonNull(result)) {
            return result;
        }
        synchronized (ThreadSafeSingleton.class) {
            if (Objects.isNull(instance)) {
                instance = new ThreadSafeSingleton(value);
            }
            return instance;

        }
    }

}
