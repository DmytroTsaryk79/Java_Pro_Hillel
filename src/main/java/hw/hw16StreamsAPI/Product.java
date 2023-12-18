package hw.hw16StreamsAPI;

import java.time.LocalDate;


class Product {
    private String category;
    private double price;
    private boolean discount;
    private LocalDate creationDate;

    public Product(String category, double price, boolean discount, LocalDate creationDate) {
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.creationDate = creationDate;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasDiscount() {
        return discount;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}