package ConcurrencyAndParallelism.ProducerConsumer;

public class Consumer implements Runnable {
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true){
            synchronized (store){
                if(!store.getItems().isEmpty()){
                    this.store.RemoveItem();
                    System.out.println("Removing item from store. Item size is " + this.store.getItems().size());
                }
            }
        }
    }
}
