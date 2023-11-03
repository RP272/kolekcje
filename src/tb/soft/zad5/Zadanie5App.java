package tb.soft.zad5;

import java.time.LocalDate;
import java.util.*;

public class Zadanie5App {
    public static void main(String[] args) {
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
