package hw.hw11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextProcessor {
        public static int countOccurrence(List<String> stringList, String target) {
        int count = 0;
        for (String str : stringList) {
            if (str.equals(target)) {
                count++;
            }
        }
        return count;
    }

       public static <T> List<T> toList(T[] array) {
        List<T> list = new ArrayList<>();
        for (T item : array) {
            list.add(item);
        }
        return list;
    }

        public static List<Integer> findUnique(List<Integer> numberList) {
        List<Integer> uniqueList = new ArrayList<>();
        for (Integer num : numberList) {
            if (!uniqueList.contains(num)) {
                uniqueList.add(num);
            }
        }
        return uniqueList;
    }

       public static List<String> calcOccurrence(List<String> wordList) {
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String word : wordList) {
            occurrenceMap.put(word, occurrenceMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

       public static List<WordOccurrence> findOccurrence(List<String> wordList) {
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String word : wordList) {
            occurrenceMap.put(word, occurrenceMap.getOrDefault(word, 0) + 1);
        }
        List<WordOccurrence> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : occurrenceMap.entrySet()) {
            result.add(new WordOccurrence(entry.getKey(), entry.getValue()));
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("bird");
        stringList.add("fox");
        stringList.add("bird");
        stringList.add("cat");
        stringList.add("dog");
        stringList.add("bird");

               System.out.println("Кількість входжень 'bird': " + countOccurrence(stringList, "bird"));

        Integer[] intArray = {1, 2, 3, 2, 1, 4, 5};
        List<Integer> intList = toList(intArray);
        System.out.println("Унікальні числа: " + findUnique(intList));

        List<String> wordList = new ArrayList<>();
        wordList.add("bird");
        wordList.add("fox");
        wordList.add("bird");
        wordList.add("cat");
        wordList.add("dog");
        calcOccurrence(wordList);

        List<WordOccurrence> wordOccurrences = findOccurrence(wordList);
        for (WordOccurrence wordOccurrence : wordOccurrences) {
            System.out.println(wordOccurrence.getName() + ": " + wordOccurrence.getOccurrence());
        }
    }
}