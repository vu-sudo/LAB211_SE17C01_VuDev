package model;

public class Rectangle extends PerimetterArea {
    private Double width;
    private Double heigh;

    public Rectangle(Double perimetter, Double area) {
        super(perimetter, area);
    }

    public Rectangle(Double weight, Double heigh, Double perimetter, Double area) {
        super(perimetter, area);
        this.width = weight;
        this.heigh = heigh;
    }
 
    
    public Double getHeigh() {
        return heigh;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getWidth() {
        return width;
    }


    public void setHeigh(Double heigh) {
        this.heigh = heigh;
    }

    @Override
    public void calculatePerimetter() {
      this.perimetter = (this.width + this.heigh) * 2;
    }

    @Override
    public void calculateArea() {
      this.area = (this.width * this.heigh);
    }

    @Override
    public String toString() {
        return "___RECTANGLE___" + "\n"
                +"Width:  " + this.width +"\n"
                +"Length: " + this.heigh +"\n"
                +"Area: " + this.area +"\n"
                +"Perimetter: " + this.perimetter;
    }
    
}
