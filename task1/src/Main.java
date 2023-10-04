class Counter {
    private int count = 0;

    public void increment() {
        int temp = count; // чтение значения count
        temp = temp + 1; // инкремент
        count = temp; // запись значения обратно в count
    }

    public int getValue() {
        return count;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Count: " + counter.getValue());
    }
}
