package main.java.hw.hw5;

public abstract class Participant {
    protected String name;
    protected int maxRunDistance;
    protected int maxJumpHeight;

    public Participant(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public abstract void run();

    public abstract void jump();

    public String getName() {
        return name;
    }
}