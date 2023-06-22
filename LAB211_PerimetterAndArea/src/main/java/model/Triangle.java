package model;

public class Triangle extends PerimetterArea {
    private Double edgeOne;
    private Double edgeTwo;
    private Double edgeThree;

    public Double getEdgeOne() {
        return edgeOne;
    }

    public Double getEdgeTwo() {
        return edgeTwo;
    }

    public Double getEdgeThree() {
        return edgeThree;
    }

    public void setEdgeOne(Double edgeOne) {
        this.edgeOne = edgeOne;
    }

    public void setEdgeTwo(Double edgeTwo) {
        this.edgeTwo = edgeTwo;
    }

    public void setEdgeThree(Double edgeThree) {
        this.edgeThree = edgeThree;
    }

    public Triangle(Double edgeOne, Double edgeTwo, Double edgeThree, Double perimetter, Double area) {
        super(perimetter, area);
        this.edgeOne = edgeOne;
        this.edgeTwo = edgeTwo;
        this.edgeThree = edgeThree;
    }
    

    public Triangle(Double perimetter, Double area) {
        super(perimetter, area);
    }

    @Override
    public void calculatePerimetter() {
        this.perimetter = this.edgeOne + this.edgeTwo + this.edgeThree;
    }

    @Override
    public void calculateArea() {
        Double s = (this.edgeOne + this.edgeTwo + this.edgeThree)/2;
        this.area = Math.sqrt(s*(s-this.edgeOne)*(s-this.edgeTwo)*(s-this.edgeThree));
    }

    @Override
    public String toString() {
        return "___TRIANGLE___" + "\n"
                +"Side A:  " + this.edgeOne +"\n"
                +"Side B: " + this.edgeTwo +"\n"
                +"Side C: " + this.edgeThree +"\n"
                +"Area:" + this.area + "\n"
                +"Perimetter: " + this.perimetter;
    }
    
}
