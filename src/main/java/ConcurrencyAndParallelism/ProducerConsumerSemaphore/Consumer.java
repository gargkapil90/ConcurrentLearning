package ConcurrencyAndParallelism.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Store store;
    private Semaphore conSema;
    private Semaphore prodSema;

    public Consumer(Store store, Semaphore conSema, Semaphore prodSema) {
        this.store = store;
        this.conSema = conSema;
        this.prodSema = prodSema;
    }

    @Override
    public void run() {
        while (true){
            try {
                conSema.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.store.RemoveItem();
            System.out.println("Removing item from store. Item size is " + this.store.getItems().size());
            prodSema.release();
        }
    }
}
