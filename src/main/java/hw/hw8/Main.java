package main.java.hw.hw8;

public class Main {
    public static void main(String[] args) {
        String inputString = "Hillel";
        String reversedString = stringReverse(inputString);
        System.out.println("Рядок '" + inputString + "' у реверсованому вигляді: " + reversedString);
        System.out.println(inputString.equalsIgnoreCase(reversedString));
    }

    public static String stringReverse(String input) {
        StringBuilder reversed = new StringBuilder(input);
        reversed.reverse();
        return reversed.toString();
    }
}