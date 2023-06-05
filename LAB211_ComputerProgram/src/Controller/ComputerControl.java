package Controller;

import Common.FunctionsLibrary;
import Common.InputLibrary;
import Model.BMIComputer;
import Model.ExpressionEvaluator;
import Model.SimpleComputer;
import View.Menu;

public class ComputerControl {
    SimpleComputer simpleComputer = new SimpleComputer();
    BMIComputer bmiComputer = new BMIComputer();

    InputLibrary inputLibrary = new InputLibrary();
    FunctionsLibrary functionsLibrary = new FunctionsLibrary();

    public void handleCalculateSimpleComputer() {
        simpleComputer.setNumber(inputLibrary.setDoubleValue("Enter number: ", "^[-+]?\\d*\\.?\\d+$"));
        simpleComputer.setMemory(simpleComputer.getNumber());
        simpleComputer.setOperator(inputLibrary.setStringValue("Enter operator: ", "[+\\-*/^=]", "Please input (+, -, *, /, ^)"));
        if(!simpleComputer.getOperator().equals("=")) {
            simpleComputer.setNumber(inputLibrary.setDoubleValue("Enter number: ", "^[-+]?\\d*\\.?\\d+$"));
            simpleComputer.setMemory(functionsLibrary.calculateResult(simpleComputer.getOperator(), simpleComputer.getMemory(), simpleComputer.getNumber()));
            System.out.println("Memory: " + simpleComputer.getMemory());
            do {
                simpleComputer.setOperator(inputLibrary.setStringValue("Enter operator: ", "[+\\-*/^=]", "Please input (+, -, *, /, ^)"));
                if(!simpleComputer.getOperator().equals("=")) {
                    simpleComputer.setNumber(inputLibrary.setDoubleValue("Enter number: ", "^[-+]?\\d*\\.?\\d+$"));
                    simpleComputer.setMemory(functionsLibrary.calculateResult(simpleComputer.getOperator(), simpleComputer.getMemory(), simpleComputer.getNumber()));
                    System.out.println("Memory: " + simpleComputer.getMemory());
                } else {
                    simpleComputer.setResult(simpleComputer.getMemory());
                }
            } while (!simpleComputer.getOperator().equals("="));
        } else {
            simpleComputer.setResult(simpleComputer.getMemory());
        }
        System.out.println("Result: " + simpleComputer.getResult());
    }

    public void handleCalculateExpression() {
        String expression = inputLibrary.setStringValue("Enter a mathematical expression: ");
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        try {
            double result = evaluator.evaluateExpression(expression);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error evaluating expression!");
        }
    }

    public void handleExecuteComputerProgram() {
        String[] options = {
            "Normal Calculator",
            "Expression Calculator"
        };
        Menu eMenu = new Menu("CHOOSE THE OPTIONS: ", options) {

            @Override
            public void execute(int number) {
                switch(number) {
                    case 1: 
                        handleCalculateSimpleComputer();
                        break;
                    case 2: 
                        handleCalculateExpression();
                        break;
                    default:
                        System.out.println("Backed to main menu!");
                        return;
                }
            }
            
        };
        eMenu.run();
    }

    public void handleCalculationBMI() {
        bmiComputer.setBodyWeight(inputLibrary.setDoubleValue("Enter Weight (kg): ", "^[-+]?\\d*\\.?\\d+$"));
        bmiComputer.setHeight(inputLibrary.setDoubleValue("Enter Height (cm): ", "^[-+]?\\d*\\.?\\d+$"));
        bmiComputer.setBmiNumber(functionsLibrary.calculateBMI(bmiComputer.getBodyWeight(), bmiComputer.getHeight()));
        bmiComputer.setStatus(functionsLibrary.returnStatus(bmiComputer.getBmiNumber()));
        System.out.println("BMI: " +  bmiComputer.getBmiNumber());
        System.out.println("BMI Status: " + bmiComputer.getStatus());
    }
}
