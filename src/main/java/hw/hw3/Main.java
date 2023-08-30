package main.java.hw.hw3;

public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобік");
        Dog dogTuzik = new Dog("Тузік");
        Cat catBarsik = new Cat("Барсік");
        Cat catMurzik = new Cat("Мурзік");

        dogBobik.run(150);
        dogTuzik.run(600);
        dogTuzik.swim(5);
        catBarsik.run(100);
        catBarsik.swim(1);
        catMurzik.swim(10);

        int totalAnimalCount = Animal.getCount();
        int totalDogCount = Dog.getCount();
        int totalCatCount = Cat.getCount();

        System.out.println("Всього тварин: " + totalAnimalCount);
        System.out.println("Собак: " + totalDogCount);
        System.out.println("Котів: " + totalCatCount);
    }
}