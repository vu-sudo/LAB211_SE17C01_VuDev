package Controller;

import Common.FunctionLibrary;
import Model.Quadratic;

public class QuadraticEquation {
    Quadratic quadraticData;
    FunctionLibrary functionLibrary = new FunctionLibrary();

    public void handleSetQuadraticData() {
        Quadratic quadratic = new Quadratic();
        quadratic.setFirstNumber(functionLibrary.setNumberCof("Enter number A: ", "^[-+]?\\d*\\.?\\d+$"));
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
