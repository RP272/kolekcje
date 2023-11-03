package tb.soft.zad8;


public class MyDate {
    private Integer year;
    private Integer month;
    private Integer day;

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
}
