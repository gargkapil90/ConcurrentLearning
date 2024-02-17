package ConcurrencyAndParallelism.ProducerConsumerSemaphore;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Store {
    private int maxSize;

    private ConcurrentLinkedQueue<Object> Items;


    public Store(int maxSize, ConcurrentLinkedQueue<Object> items) {
        this.maxSize = maxSize;
        this.Items = items;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public ConcurrentLinkedQueue<Object> getItems() {
        return Items;
    }

    public void AddItem(){
        this.Items.add(new Object());
    }

    public void RemoveItem()
    {
        this.Items.remove();
    }

}
