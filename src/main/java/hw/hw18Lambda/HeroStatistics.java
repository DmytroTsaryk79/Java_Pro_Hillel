package hw.hw18Lambda;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HeroStatistics {

    public static double averageHeight(List<Hero> heroes) {
        return heroes.stream()
                .filter(hero -> hero.height > 0)
                .mapToDouble(hero -> hero.height)
                .average()
                .orElse(0);
    }

    public static String tallestHeroName(List<Hero> heroes) {
        return heroes.stream()
                .filter(hero -> hero.height > 0)
                .max(Comparator.comparingDouble(hero -> hero.height))
                .map(hero -> hero.name)
                .orElse("");
    }

    public static String heaviestHeroName(List<Hero> heroes) {
        return heroes.stream()
                .max(Comparator.comparingInt(hero -> hero.weight))
                .map(hero -> hero.name)
                .orElse("");
    }

    public static Map<String, Long> countByGender(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(hero -> hero.gender, Collectors.counting()));
    }

    public static Map<String, Long> countByAlignment(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(hero -> hero.alignment, Collectors.counting()));
    }

    public static List<String> mostPopularPublishers(List<Hero> heroes, int topCount) {
        return heroes.stream()
                .collect(Collectors.groupingBy(hero -> hero.publisher, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> mostPopularHairColors(List<Hero> heroes, int topCount) {
        return heroes.stream()
                .collect(Collectors.groupingBy(hero -> hero.hairColor, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(topCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static String mostPopularEyeColor(List<Hero> heroes) {
        return heroes.stream()
                .collect(Collectors.groupingBy(hero -> hero.eyeColor, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.<String, Long>comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public static void main(String[] args) {
        try {
            List<Hero> heroes = loadHeroesFromUrl("https://github.com/eugine/hillel-threads/raw/main/src/main/resources/heroes_information.csv");

            System.out.println("Average height: " + averageHeight(heroes));
            System.out.println("The tallest hero: " + tallestHeroName(heroes));
            System.out.println("The heaviest hero: " + heaviestHeroName(heroes));
            System.out.println("Gender counts: " + countByGender(heroes));
            System.out.println("Alignment counts: " + countByAlignment(heroes));
            System.out.println("5 most popular publishers: " + mostPopularPublishers(heroes, 5));
            System.out.println("3 most popular hair colors: " + mostPopularHairColors(heroes, 3));
            System.out.println("The most popular eye color: " + mostPopularEyeColor(heroes));

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static List<Hero> loadHeroesFromUrl(String url) throws IOException, URISyntaxException {
        return Files.lines(Paths.get(new URI(url)))
                .map(line -> line.split(";"))
                .map(parts -> new Hero(
                        parts[0], parts[1], parts[2], parts[3], parts[4],
                        Double.parseDouble(parts[5]), parts[6], parts[7], parts[8],
                        Integer.parseInt(parts[9])
                ))
                .collect(Collectors.toList());
    }
}