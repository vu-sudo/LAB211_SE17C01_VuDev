package Model;

import java.util.ArrayList;

public class Maxmin {
    private ArrayList<Person> max;
    private ArrayList<Person> min;
    
    public ArrayList<Person> getMax() {
        return max;
    }
    public ArrayList<Person> getMin() {
        return min;
    }
    public void setMax(Person max) {
        this.max.add(max);
    }
    public void setMin(Person min) {
        this.min.add(min);
    }
    public Maxmin(Person max, Person min) {
        super();
        this.max.add(max);
        this.min.add(min);
    }
    public Maxmin() {
        super();
        this.max = new ArrayList<Person>();
        this.min = new ArrayList<Person>();
    }

    @Override
    public String toString() {
        return "Max: " + this.max + "\n" + "Min: " + this.min;
    }
}
