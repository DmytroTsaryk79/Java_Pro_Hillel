package main.java.hw.hw5;

public class Robot extends Participant {
    public Robot(String name) {
        super(name, 10000, 1);
    }

    @Override
    public void run() {
        System.out.println("Робот " + name + " пробігає бігову доріжку.");
    }

    @Override
    public void jump() {
        System.out.println("Робот " + name + " стрибає через перешкоду.");
    }
}