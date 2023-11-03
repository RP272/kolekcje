package tb.soft.zad5;

import java.time.LocalDate;

public class Order implements Comparable<Order> {
    private int id;
    private LocalDate created;

    private double price;
    public double getPrice() {
        return price;
    }

    public Order(int id, LocalDate created, double price) {
        this.id = id;
        this.created = created;
        this.price = price;
    }

    @Override
    public int compareTo(Order o) {
        return this.created.compareTo(o.created);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", created=" + created +
                ", price=" + price +
                '}';
    }
}
