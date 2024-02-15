package ConcurrencyAndParallelism.Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        List<Integer> inputs = List.of(4,2,7,55,22,11);
        Sorter sorter = new Sorter(inputs, es);
        Future<List<Integer>> sortedArrayPromise = es.submit(sorter);
        List<Integer> sortedArray =  sortedArrayPromise.get();
        for(int i = 0; i < sortedArray.size(); i++){
            System.out.print(sortedArray.get(i) + ",");
        }
    }
}
