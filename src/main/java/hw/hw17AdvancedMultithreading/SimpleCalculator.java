package hw.hw17AdvancedMultithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SimpleCalculator {

    public int squareSum(int first, int second) {
        CompletableFuture<Integer> squareFirst = CompletableFuture.supplyAsync(() -> first * first);
        CompletableFuture<Integer> squareSecond = CompletableFuture.supplyAsync(() -> second * second);

        return squareFirst.thenCombine(squareSecond, Integer::sum)
                .join();
    }

    public static class ThreadSafeList<T> {
        private final List<T> list = new ArrayList<>();
        private final ReadWriteLock lock = new ReentrantReadWriteLock();

        public void add(T value) {
            lock.writeLock().lock();
            try {
                list.add(value);
            } finally {
                lock.writeLock().unlock();
            }
        }

        public T remove(int index) {
            lock.writeLock().lock();
            try {
                return list.remove(index);
            } finally {
                lock.writeLock().unlock();
            }
        }

        public T get(int index) {
            lock.readLock().lock();
            try {
                return list.get(index);
            } finally {
                lock.readLock().unlock();
            }
        }
    }

    public static void main(String[] args) {
        SimpleCalculator calculator = new SimpleCalculator();
        int result = calculator.squareSum(3, 4);
        System.out.println("Square Sum: " + result);

        ThreadSafeList<String> threadSafeList = new ThreadSafeList<>();
        threadSafeList.add("Item1");
        threadSafeList.add("Item2");

        String item = threadSafeList.get(0);
        System.out.println("Item at index 0: " + item);

        String removedItem = threadSafeList.remove(1);
        System.out.println("Removed item: " + removedItem);
    }
}