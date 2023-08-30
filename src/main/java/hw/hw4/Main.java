package main.java.hw.hw4;

public class Main {
    public static void main(String[] args) {

        Circle circle = new Circle(5);
        Triangle triangle = new Triangle(4, 6);
        Square square = new Square(3);

        Shape[] shapesArray = {circle, triangle, square};

        double totalArea = sumAreas(shapesArray);
        System.out.println("Сумарна площа усіх фігур: " + totalArea);
    }
    public static double sumAreas(Shape[] shapes) {
        double totalArea = 0;
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
}