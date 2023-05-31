package Model;

import java.util.ArrayList;


public class TypeOfNumber {
    private ArrayList<Double> odd;
    private ArrayList<Double> even;
    private ArrayList<Double> perfect;

    public TypeOfNumber() {
        super();
        this.odd = new ArrayList<Double>();
        this.even = new ArrayList<Double>();
        this.perfect = new ArrayList<Double>();
    }

    public void setOdd(Double odd) {
        this.odd.add(odd);
    }

    public void setEven(Double even) {
        this.even.add(even);
    }

    public void setPerfect(Double perfect) {
        this.perfect.add(perfect);
    }

    public ArrayList<Double> getEven() {
        return even;
    }

    public ArrayList<Double> getPerfect() {
        return perfect;
    }


    @Override
    public String toString() {
        return "Odd " + (this.odd.size() == 1 ? "number is: " : "numbers are: ") + (this.odd.isEmpty() ? "Empty" : this.odd) + "\n"
            +  "Even " + (this.even.size() == 1 ? "number is: " : "numbers are: ") + (this.even.isEmpty() ? "Empty" : this.even) + "\n"
            +  "Perfect Square " + (this.perfect.size() == 1 ? "number is: " : "numbers are: ") + (this.perfect.isEmpty() ? "Empty" : this.perfect);
    }
    
}   
