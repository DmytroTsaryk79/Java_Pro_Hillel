package hw.hw16Multithreading;

public class ArrayInitializer {

    public static void init(double[] array) {
        int n = array.length;

        int middle = n / 2;
        double[] firstHalf = new double[middle];
        double[] secondHalf = new double[n - middle];

         for (int i = 0; i < middle; i++) {
            firstHalf[i] = array[i];
            secondHalf[i] = array[middle + i];
        }

        Thread thread1 = new Thread(() -> calculateValues(firstHalf, 0, middle, array));
        Thread thread2 = new Thread(() -> calculateValues(secondHalf, middle, n, array));

        thread1.start();
        thread2.start();

        try {
            // Очікуємо завершення обох потоків
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void calculateValues(double[] sourceArray, int startIndex, int endIndex, double[] targetArray) {
        for (int i = startIndex; i < endIndex; i++) {
            targetArray[i] = sourceArray[i - startIndex] *
                    Math.sin(0.2 + i / 5.0) *
                    Math.cos(0.2 + i / 5.0) *
                    Math.cos(0.4 + i / 2.0);
        }
    }

    public static void main(String[] args) {
        // Створюємо масив та заповнюємо його однаковим значенням
        int arraySize = 10;
        double[] array = new double[arraySize];
        double initialValue = 1.0;

        for (int i = 0; i < arraySize; i++) {
            array[i] = initialValue;
        }

        // Викликаємо init() для ініціалізації масиву
        init(array);

        // Виводимо отриманий масив
        for (double value : array) {
            System.out.println(value);
        }
    }
}
