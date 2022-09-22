package ua.hillel.homework;

import java.time.LocalDateTime;

public class Product2 {
    private String type;
    private int price;
    private int discount;
    private LocalDateTime date;
    private int id;

    public Product2(String type, int price, int discount, int id) {
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.date = LocalDateTime.now();
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return type + ", price=" + price + ", discount = " + discount + "; ";
    }
}
