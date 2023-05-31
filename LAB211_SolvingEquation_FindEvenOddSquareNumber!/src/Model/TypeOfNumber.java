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
        return "Number is Odd: " + (this.odd.isEmpty() ? "Empty" : this.odd) + "\n"
            +  "Number is Even: " + (this.even.isEmpty() ? "Empty" : this.even) + "\n"
            +  "Number is Perfect Square: " + (this.perfect.isEmpty() ? "Empty" : this.perfect);
    }
    
}   
