package Model;

import java.util.ArrayList;

import Common.FunctionLibrary;

public class Quadratic {
    private TypeOfNumber typeOfNumber = new TypeOfNumber();
    private Double firstNumber;
    private Double secondNumber;
    private Double thirdNumber;
    private ArrayList<Double> result;
    
    FunctionLibrary functionLibrary = new FunctionLibrary();
    public Double getFirstNumber() {
        return firstNumber;
    }
    public TypeOfNumber getTypeOfNumber() {
        return typeOfNumber;
    }
    public Double getSecondNumber() {
        return secondNumber;
    }
    public Double getThirdNumber() {
        return thirdNumber;
    }
    public void setFirstNumber(Double firstNumber) {
        this.firstNumber = firstNumber;
        if(firstNumber %2 == 0) {
            typeOfNumber.setEven(firstNumber);
        } else {
            typeOfNumber.setOdd(firstNumber);
        }
        if(functionLibrary.isPerfectSquareNumber(firstNumber)) {
            typeOfNumber.setPerfect(firstNumber);
        }
    }
    @Override
    public String toString() {
        return (!this.result.isEmpty() ? "Solution: " + "x1 = " + this.result.get(0) + ", x2 = " + this.result.get(1) : "Solution: The equation has no solution") +  "\n"
        + this.typeOfNumber;
    }
    public void setSecondNumber(Double secondNumber) {
        this.secondNumber = secondNumber;
        if(secondNumber %2 == 0) {
            typeOfNumber.setEven(secondNumber);
        } else {
            typeOfNumber.setOdd(secondNumber);
        }
        if(functionLibrary.isPerfectSquareNumber(secondNumber)) {
            typeOfNumber.setPerfect(secondNumber);
        }
    }
    public ArrayList<Double> getResult() {
        return result;
    }
    public void setResult(Double result) {
        this.result.add(result);
    }
    public void setThirdNumber(Double thirdNumber) {
        this.thirdNumber = thirdNumber;
        if(thirdNumber %2 == 0) {
            typeOfNumber.setEven(thirdNumber);
        } else {
            typeOfNumber.setOdd(thirdNumber);
        }
        if(functionLibrary.isPerfectSquareNumber(thirdNumber)) {
            typeOfNumber.setPerfect(thirdNumber);
        }
    }

    public Quadratic() {
        super();
        this.result = new ArrayList<Double>();
    }
    public void setTypeOfNumber(TypeOfNumber typeOfNumber) {
        this.typeOfNumber = typeOfNumber;
    }
    public void calculateQuadraticResult() {
        this.result.clear();
        double discriminant = secondNumber * secondNumber - 4 * firstNumber * thirdNumber;
        if(discriminant > 0) {
            this.result.add( (double) Math.round((-secondNumber + Math.sqrt(discriminant)) / (2 * firstNumber)*1000)/1000 );
            this.result.add( (double) Math.round(( secondNumber + Math.sqrt(discriminant)) / (2 * firstNumber)*1000)/1000 );
        } else if(discriminant == 0) {
            this.result.add( (double) Math.round( (-secondNumber / (2 * firstNumber)) *1000 ) / 1000 );
            this.result.add( (double) Math.round( (-secondNumber / (2 * firstNumber)) *1000 ) / 1000 );
        }

       if(!this.result.isEmpty()) {
            if(this.result.get(0) %2 == 0) this.typeOfNumber.setEven(this.result.get(0)); 
            else this.typeOfNumber.setOdd(this.result.get(0));

            if(this.result.get(1) %2 == 0) this.typeOfNumber.setEven(this.result.get(1));
            else this.typeOfNumber.setOdd(this.result.get(1));

            if(functionLibrary.isPerfectSquareNumber(this.result.get(0))) this.typeOfNumber.setPerfect(this.result.get(0));
            if(functionLibrary.isPerfectSquareNumber(this.result.get(1))) this.typeOfNumber.setPerfect(this.result.get(1));
       }
    }
}
