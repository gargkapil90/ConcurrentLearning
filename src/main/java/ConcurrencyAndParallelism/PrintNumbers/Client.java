package ConcurrencyAndParallelism.PrintNumbers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
//        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es = Executors.newFixedThreadPool(10);

        for (int i = 1; i <= 500000; i++){
            PrintNumber pn = new PrintNumber(i);
//            Thread th = new Thread(pn);
//            th.start();
            es.submit(pn);

        }
    }
}
