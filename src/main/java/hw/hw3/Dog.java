package main.java.hw.hw3;

public class Dog extends Animal {
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;

    public Dog(String name) {
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
        if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(getName() + " проплив " + distance + " м");
        } else {
            System.out.println(getName() + " не може пропливти таку дистанцію");
        }
    }
}