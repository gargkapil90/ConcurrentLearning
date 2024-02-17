package ConcurrencyAndParallelism.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Store store;
    private Semaphore conSema;
    private Semaphore prodSema;

    public Producer(Store store, Semaphore conSema, Semaphore prodSema) {
        this.store = store;
        this.conSema = conSema;
        this.prodSema = prodSema;
    }

    @Override
    public void run() {
        while (true){
            try {
                prodSema.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.store.AddItem();
            System.out.println("Adding item from store. Item size is " + this.store.getItems().size());
            conSema.release();
        }
    }
}
