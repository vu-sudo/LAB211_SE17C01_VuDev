package controller;

import common.InputFunctions;
import model.Circel;
import model.Rectangle;
import model.Triangle;

public class PerimetterAndArea {
    
    private final InputFunctions inputFunctions = new InputFunctions();
    private final Rectangle rectangle = new Rectangle(Double.NaN, Double.NaN, Double.MAX_VALUE, Double.NaN);
    private final Circel circel = new Circel(Double.MAX_VALUE, Double.NaN);
    private final Triangle triangle = new Triangle(Double.MAX_VALUE, Double.NaN);
    
    public void setRetangleValue() {
        rectangle.setWidth(inputFunctions.setDoubleValue("Please input side width of Rectangle: "));
        rectangle.setHeigh(inputFunctions.setDoubleValue("Please input length of Rectangle: "));
        rectangle.calculatePerimetter();
        rectangle.calculateArea();
    }
    public void setCircelValue() {
        circel.setRadius(inputFunctions.setDoubleValue("Please input radius of the Circel: "));
        circel.calculatePerimetter();
        circel.calculateArea();
    }
    
    public void setTriangleValue() {
        triangle.setEdgeOne(inputFunctions.setDoubleValue("Please input side A of Triangle: "));
        triangle.setEdgeTwo(inputFunctions.setDoubleValue("Please input side B of Triangle: "));
        triangle.setEdgeThree(inputFunctions.setDoubleValue("Please input side C of Triangle: "));
        triangle.calculatePerimetter();
        triangle.calculateArea();        
    }
    
    public void display() {
        System.out.println(rectangle);
        System.out.println(circel);
        System.out.println(triangle);
    }
}
