package tb.soft.zad5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Order implements Comparable<Order> {
    private final int id;
    private final LocalDate created;

    private final double price;
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

    public static void try_sorting(){
        List<Order> list = new ArrayList<>();
        list.add(new Order(1, LocalDate.of(2023, 11, 3), 30.5));
        list.add(new Order(2, LocalDate.of(1997, 11, 2), 24.7));
        list.add(new Order(3, LocalDate.of(2004, 11, 2), 12.7));

        System.out.println("Not sorted: \n" + list);
        Collections.sort(list);
        System.out.println("Sorted by date: \n" + list);

        Collections.sort(list, new Comparator<Order>() {
            @Override
            public int compare(Order o1, Order o2) {
                if(o1.getPrice() > o2.getPrice()) return 1;
                if(o1.getPrice() < o2.getPrice()) return -1;
                return 0;
            }
        });
        System.out.println("Sorted by price: \n" + list);
    }
}
