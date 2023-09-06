package main.java.hw.hw5;

public abstract class Obstacle {
    protected String name;
    protected int value;

    public Obstacle(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public abstract boolean overcome(Participant participant);
}