package ConcurrencyAndParallelism.Synchronization;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Adder implements Callable<Void> {
    private Value val;
    private final Lock lock;

    public Adder(Value val, Lock lock) {
        this.val = val;
        this.lock = lock;
    }

    @Override
    public Void call() {
//        Lock lock = new ReentrantLock();
        for(int i = 1; i < 10000; i++){
            lock.lock();
            val.val += i;
            lock.unlock();
            System.out.println("after adding " +val.val);
        }
        return null;
    }
}
