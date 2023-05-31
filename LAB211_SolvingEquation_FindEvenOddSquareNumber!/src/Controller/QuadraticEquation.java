package Controller;

import Common.FunctionLibrary;
import Model.Quadratic;

public class QuadraticEquation {
    Quadratic quadraticData;
    FunctionLibrary functionLibrary = new FunctionLibrary();

    public void handleSetQuadraticData() {
        Quadratic quadratic = new Quadratic();
        double aValue = 0;
        do {
            aValue = functionLibrary.setNumber("Enter number A: ", "^[-+]?\\d*\\.?\\d+$");
            if(aValue == 0) {
                System.out.println("Number A must be greater than 0! Please try again!");
            }
        } while (aValue == 0);
        quadratic.setFirstNumber(aValue);
        quadratic.setSecondNumber(functionLibrary.setNumber("Enter number B: ", "^[-+]?\\d*\\.?\\d+$"));
        quadratic.setThirdNumber(functionLibrary.setNumber("Enter number C: ", "^[-+]?\\d*\\.?\\d+$"));
        quadratic.calculateQuadraticResult();
        quadraticData = quadratic;
        handleDisplayQuadraticData();
    }
    public void handleDisplayQuadraticData() {
        System.out.println(quadraticData);
    }
}
