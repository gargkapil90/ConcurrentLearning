package ConcurrencyAndParallelism.ProducerConsumerSemaphore;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Store store = new Store(5, new ConcurrentLinkedQueue<>());
        ExecutorService es = Executors.newCachedThreadPool();
        Semaphore conSema = new Semaphore(0);
        Semaphore prodSema = new Semaphore(5);

        for(int i = 0; i < 8; i++){
            Producer producer = new Producer(store, conSema, prodSema);
            es.execute(producer);
        }
        for(int i = 0; i < 20; i++){
            Consumer consumer = new Consumer(store, conSema, prodSema);
            es.execute(consumer);
        }
    }
}
