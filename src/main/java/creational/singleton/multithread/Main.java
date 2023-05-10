package creational.singleton.multithread;

public class Main {
    public static void main(String[] args) {
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            MultiThreadSingleton singleton = MultiThreadSingleton.getInstance("FOO");
            System.out.println(singleton.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            MultiThreadSingleton singleton = MultiThreadSingleton.getInstance("BAR");
            System.out.println(singleton.value);
        }
    }
}

