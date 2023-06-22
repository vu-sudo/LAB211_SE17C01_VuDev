package model;

public abstract class PerimetterArea {
    protected Double perimetter;
    protected Double area;

    public Double getPerimetter() {
        return perimetter;
    }

    public Double getArea() {
        return area;
    }

    public void setPerimetter(Double perimetter) {
        this.perimetter = perimetter;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public PerimetterArea(Double perimetter, Double area) {
        this.perimetter = perimetter;
        this.area = area;
    }
    
    public abstract void calculatePerimetter();    
    public abstract void calculateArea();


    @Override
    public String toString() {
        return "PerimetterArea{" + "perimetter=" + perimetter + ", area=" + area + '}';
    }
    
    
}
