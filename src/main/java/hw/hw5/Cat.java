package main.java.hw.hw5;

public class Cat extends Participant {
    public Cat(String name) {
        super(name, 2000, 3);
    }

    @Override
    public void run() {
        System.out.println("Кіт " + name + " пробігає бігову доріжку.");
    }

    @Override
    public void jump() {
        System.out.println("Кіт " + name + " стрибає через перешкоду.");
    }
}