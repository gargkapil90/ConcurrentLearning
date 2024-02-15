package ConcurrencyAndParallelism.IntroToThread;

public class Client {
    public static void main(String[] args) {
        System.out.println("Current thread " + Thread.currentThread().getName());
        Printer p = new Printer();
        Thread th = new Thread(p);
        th.start();
        System.out.println("Main completed");
    }
}
