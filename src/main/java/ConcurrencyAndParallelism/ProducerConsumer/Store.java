package ConcurrencyAndParallelism.ProducerConsumer;

import java.util.List;

public class Store {
    private int maxSize;

    private List<Object> Items;


    public Store(int maxSize, List<Object> items) {
        this.maxSize = maxSize;
        this.Items = items;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public List<Object> getItems() {
        return Items;
    }

    public void AddItem(){
        this.Items.add(new Object());
    }

    public void RemoveItem(){
        this.Items.remove(this.Items.size()-1);
    }

}
