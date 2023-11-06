package tb.soft.zad8;


import java.util.HashMap;
import java.util.Map;

public class MyDate {
    private final Integer year;
    private final Integer month;
    private final Integer day;

    public MyDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if(year != null){
            result = 31 * result + year.hashCode();
        }
        if(month != null){
            result = 31 * result + month.hashCode();
        }
        if(day != null){
            result = 31 * result + day.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this)
            return true;
        if(!(obj instanceof MyDate))
            return false;
        MyDate tmp = (MyDate)obj;
        return (year.equals(tmp.year) && month.equals(tmp.month) && day.equals(tmp.day));
    }

    public static void try_putting() {
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
