package hw.hw16StreamsAPI;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ProductOperations {

    public static List<Product> getExpensiveBooks(List<Product> products) {
        return products.stream()
                .filter(product -> "Book".equals(product.getCategory()) && product.getPrice() > 250)
                .collect(Collectors.toList());
    }

    public static List<Product> getDiscountedBooks(List<Product> products) {
        return products.stream()
                .filter(product -> "Book".equals(product.getCategory()) && product.hasDiscount())
                .map(product -> new Product(product.getCategory(), product.getPrice() * 0.9, false, product.getCreationDate()))
                .collect(Collectors.toList());
    }

    public static Product getCheapestBook(List<Product> products) {
        return products.stream()
                .filter(product -> "Book".equals(product.getCategory()))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("No Book found"));
    }

    public static List<Product> getLastThreeAddedProducts(List<Product> products) {
        return products.stream()
                .sorted(Comparator.comparing(Product::getCreationDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    public static double calculateTotalCost(List<Product> products) {
        return products.stream()
                .filter(product -> "Book".equals(product.getCategory()))
                .filter(product -> product.getCreationDate().getYear() == LocalDate.now().getYear())
                .filter(product -> product.getPrice() <= 75)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    public static Map<String, List<Product>> groupProductsByCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Book", 300, true, LocalDate.now().minusDays(10)),
                new Product("Book", 200, false, LocalDate.now().minusDays(5)),
                new Product("Toy", 100, true, LocalDate.now().minusDays(2)),
                new Product("Book", 50, false, LocalDate.now())
        );

        List<Product> expensiveBooks = getExpensiveBooks(products);
        System.out.println("Expensive Books: " + expensiveBooks);

        List<Product> discountedBooks = getDiscountedBooks(products);
        System.out.println("Discounted Books: " + discountedBooks);

        Product cheapestBook = getCheapestBook(products);
        System.out.println("Cheapest Book: " + cheapestBook);

        List<Product> lastThreeAdded = getLastThreeAddedProducts(products);
        System.out.println("Last Three Added Products: " + lastThreeAdded);

        double totalCost = calculateTotalCost(products);
        System.out.println("Total Cost of Books added this year under $75: " + totalCost);

        Map<String, List<Product>> groupedProducts = groupProductsByCategory(products);
        System.out.println("Grouped Products: " + groupedProducts);
    }
}