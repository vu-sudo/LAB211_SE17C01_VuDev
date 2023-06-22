package model;

public class Circel extends PerimetterArea {
    private Double radius;

    public Circel(Double perimetter, Double area) {
        super(perimetter, area);
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimetter() {
        this.perimetter = 2 * Math.PI * this.radius;
    }

    @Override
    public void calculateArea() {
       this.area = Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public String toString() {
        return "___CIRCLE___" + "\n"
                +"Radius: " + this.radius + "\n"
                +"Area: " + this.area +"\n"
                +"Perimetter: " + this.perimetter;
    }
    
    
}
