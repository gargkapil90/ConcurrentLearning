package ConcurrencyAndParallelism.Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    private List<Integer> arrayToSort;
    private ExecutorService es;

    public Sorter(List<Integer> arrayToSort, ExecutorService es) {
        this.arrayToSort = arrayToSort;
        this.es = es;
    }

    @Override
    public List<Integer> call() throws Exception {

        if(arrayToSort.size() <= 1){
            return arrayToSort;
        }
        List<Integer> leftArrayToSort = new ArrayList<>();
        List<Integer> rightArrayToSort = new ArrayList<>();
        int size = arrayToSort.size();
        int mid = size/2;
        for(int i = 0; i < mid; i++){
            leftArrayToSort.add(arrayToSort.get(i));
        }
        for(int i = mid; i < size; i++){
            rightArrayToSort.add(arrayToSort.get(i));
        }

        Sorter leftArraySorter = new Sorter(leftArrayToSort, es);
        Sorter rightArraySorter = new Sorter(rightArrayToSort, es);

//        ExecutorService es = Executors.newCachedThreadPool();

        Future<List<Integer>> leftPromise = es.submit(leftArraySorter);
        Future<List<Integer>> rightPromise = es.submit(rightArraySorter);

        List<Integer> leftSortedArray = leftPromise.get();
        List<Integer> rightSortedArray = rightPromise.get();

        int i = 0;
        int j = 0;
        ArrayList<Integer> sortedArray = new ArrayList<>();
        while(i < leftSortedArray.size() && j < rightSortedArray.size()){
            if(leftSortedArray.get(i) < rightSortedArray.get(j)){
                sortedArray.add(leftSortedArray.get(i++));
            }else{
                sortedArray.add(rightSortedArray.get(j++));
            }
        }
        while (i < leftSortedArray.size()){
            sortedArray.add(leftSortedArray.get(i++));
        }
        while (j < rightSortedArray.size()){
            sortedArray.add(rightSortedArray.get(j++));
        }
        return sortedArray;

    }
}
