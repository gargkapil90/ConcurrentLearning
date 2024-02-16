package ConcurrencyAndParallelism.Synchronization;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Value v = new Value();
        Lock lock = new ReentrantLock();
        Adder add = new Adder(v, lock);
        Subtractor sub = new Subtractor(v, lock);
        ExecutorService es = Executors.newCachedThreadPool();
        Future<Void> added = es.submit(add);
        Future<Void> subt = es.submit(sub);
        added.get();
        subt.get();
        System.out.println(v.val);

    }
}
