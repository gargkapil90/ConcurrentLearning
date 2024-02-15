package ConcurrencyAndParallelism.PrintNumbers;

public class Client {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++){
            PrintNumber pn = new PrintNumber(i);
            Thread th = new Thread(pn);
            th.start();
        }
    }
}
