package ConcurrencyAndParallelism.ProducerConsumer;

public class Producer implements Runnable{
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true){
            synchronized (store){
                if(store.getItems().size() < store.getMaxSize()){
                    this.store.AddItem();
                    System.out.println("Adding item from store. Item size is " + this.store.getItems().size());
                }
            }
        }
    }
}
