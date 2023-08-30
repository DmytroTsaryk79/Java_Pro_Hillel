package main.java.hw.hw5;

public class Human extends Participant {
    public Human(String name) {
        super(name, 5000, 2);
    }

    @Override
    public void run() {
        System.out.println("Людина " + name + " пробігає бігову доріжку.");
    }

    @Override
    public void jump() {
        System.out.println("Людина " + name + " стрибає через перешкоду.");
    }
}