package main.java.hw.hw2;

public class Car {
    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
    }
    private void startElectricity() {
        System.out.println("Запуск електросистеми автомобіля");
    }
    private void startCommand() {
        System.out.println("Запуск двигуна");
    }
    private void startFuelSystem() {
        System.out.println("Запуск паливної системи");
    }

    public static void main(String[] args) {
        Car Car = new Car();
        Car.start();
    }
}