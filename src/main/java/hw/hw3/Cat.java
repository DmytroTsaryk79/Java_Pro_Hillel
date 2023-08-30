package main.java.hw.hw3;

public class Cat extends Animal {
    private static final int MAX_RUN_DISTANCE = 200;
    private static final int MAX_SWIM_DISTANCE = 0;

    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(getName() + " пробіг " + distance + " м");
        } else {
            System.out.println(getName() + " не може пробігти таку дистанцію");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не вміє плавати");
    }
}