package main.java.hw.hw3;

public abstract class Animal {
    private static int count = 0;
    private final String name;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public String getName() {
        return name;
    }

    public static int getCount() {
        return count;
    }
}