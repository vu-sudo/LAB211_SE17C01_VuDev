package Controller;

import Common.FunctionLibrary;
import Model.Superlative;

public class SuperlativeEquation {
    Superlative superlativeData;
    FunctionLibrary functionLibrary = new FunctionLibrary();

    public void handleSetSuperlativeData() {
        System.out.println();
        Superlative superlative = new Superlative();
        superlative.setFirstNumber(functionLibrary.setNumberCof("Enter number A: ", "^[-+]?\\d*\\.?\\d+$"));
        superlative.setSecondNumber(functionLibrary.setNumber("Enter number B: ", "^[-+]?\\d*\\.?\\d+$"));
        superlative.calculateSuperlativeEquationResult();
        superlativeData = superlative;
        handleDisplaySuperlativeData();
    }
    public void handleDisplaySuperlativeData() {
        System.out.println(superlativeData);
    }
}
