package main.java.hw.hw6;

public class Main {
    public static void main(String[] args) {
        String inputString = "Hello Hillel school!";
        char targetSymbol = 'h';

        int occurrences = findSymbolOccurance(inputString, targetSymbol);
        System.out.println("Символ " + targetSymbol + " зустрічається " + occurrences + " раз у рядку");
    }

    public static int findSymbolOccurance(String input, char targetSymbol) {
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == targetSymbol) {
                count++;
            }
        }

        return count;
    }
}