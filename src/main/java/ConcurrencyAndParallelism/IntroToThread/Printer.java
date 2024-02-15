package ConcurrencyAndParallelism.IntroToThread;

public class Printer implements Runnable{
    @Override
    public void run() {
        System.out.println("Printer running on " + Thread.currentThread().getName());
    }
}
