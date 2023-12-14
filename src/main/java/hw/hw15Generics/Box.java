package hw.hw15Generics;

import java.util.ArrayList;
import java.util.List;

class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();


    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

       public void addFruits(List<T> newFruits) {
        fruits.addAll(newFruits);
    }

      public float getWeight() {
        if (fruits.isEmpty()) {
            return 0.0f;
        }

        float fruitWeight = fruits.get(0) instanceof Apple ? 1.0f : 1.5f;
        return fruitWeight * fruits.size();
    }

    public boolean compare(Box<?> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001;
    }

     public void merge(Box<T> otherBox) {
        if (this.getClass() != otherBox.getClass()) {
            throw new IllegalArgumentException("Неможливо об'єднати коробки з різними типами фруктів.");
        }

        this.fruits.addAll(otherBox.fruits);
        otherBox.fruits.clear();
    }
}