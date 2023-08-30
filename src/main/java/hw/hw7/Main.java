package main.java.hw.hw7;

public class Main {
    public static void main(String[] args) {
        String source = "Hello Hillel school!";
        String target = "lo";

        int position = findWordPosition(source, target);
        if (position != -1) {
            System.out.println("Слово '" + target + "' знаходиться на позиції " + position + " у рядку.");
        } else {
            System.out.println("Слово '" + target + "' не знайдено у рядку.");
        }
    }

    public static int findWordPosition(String source, String target) {
        int position = source.indexOf(target);
        return position;
    }
}