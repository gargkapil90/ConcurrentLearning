package ConcurrencyAndParallelism.PrintNumbers;

public class PrintNumber implements Runnable{
    private int number;

    public PrintNumber(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Number " + this.number + " printed by thread " + Thread.currentThread().getName());
    }
}
