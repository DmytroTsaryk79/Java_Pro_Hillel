package main.java.hw.hw9;

public class Main {
    public static void main(String[] args) {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
                "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
                "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        String targetWord = words[random.nextInt(words.length)];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Спробуйте вгадати загадане слово ");

        while (true) {
            System.out.print("Ваша відповідь: ");
            String userGuess = scanner.nextLine().toLowerCase();

            if (userGuess.equals(targetWord)) {
                System.out.println("Ви вгадали! Загадане слово: " + targetWord);
                break;
            } else {
                StringBuilder maskedWord = new StringBuilder("###############");
                int minLength = Math.min(targetWord.length(), userGuess.length());

                for (int i = 0; i < minLength; i++) {
                    if (targetWord.charAt(i) == userGuess.charAt(i)) {
                        maskedWord.setCharAt(i, userGuess.charAt(i));
                    }
                }

                System.out.println("Ви не вгадали, спробуйте ще раз: " + maskedWord);
            }
        }

        scanner.close();
    }
}