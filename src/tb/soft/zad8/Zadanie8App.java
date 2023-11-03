package tb.soft.zad8;

import java.util.HashMap;
import java.util.Map;

public class Zadanie8App {

    public static void main(String[] args) {
        Map<MyDate, String> my_map = new HashMap<>();
        my_map.put(new MyDate(2002, 20, 10), "Dzień dobry");
        my_map.put(new MyDate(2001, 20, 10), "Dzień dobry #2");
        my_map.put(new MyDate(2000, 20, 10), "Dzień dobry #3");
        MyDate d1 = new MyDate(2002, 20, 10);
        MyDate d2 = new MyDate(2001, 20, 10);
        MyDate d3 = new MyDate(2000, 20, 10);
        String result1 = my_map.get(d1);
        String result2 = my_map.get(d2);
        String result3 = my_map.get(d3);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
