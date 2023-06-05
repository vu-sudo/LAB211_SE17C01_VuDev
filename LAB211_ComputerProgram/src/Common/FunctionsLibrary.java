package Common;

public class FunctionsLibrary {
       public Double calculateResult(String operator, Double memory, Double number) {
        switch(operator) {
            case "+" : 
                return memory + number;
            case "-" :
                return memory - number;
            case "*" :
                return memory * number;
            case "/" : 
                if (number == 0) {
                    throw new ArithmeticException("Invalid expression: Division by zero");
                }
                return memory / number;
            case "^" :
                double temp = memory;
                for(int i = 0; i < number; i++) {
                    temp = temp * temp;
                }   
                return temp;
            default: 
            return null;
        }
    }
    public Double calculateBMI(Double weight, Double height) {
        return weight / (height/100*height/100);
    }
    public String returnStatus(Double BMINumber) {
        if(BMINumber < 19) {
            return "Under-Standard";
        } else if(BMINumber >= 19 && BMINumber <= 25) {
            return "Standard";
        } else if(BMINumber > 25 && BMINumber <= 30) {
            return "Over-Weight";
        } else if(BMINumber > 30 && BMINumber <= 40) {
            return "Fat - should lose weight";
        } else if(BMINumber > 40) {
            return "Very Fat - should lose weight immediately";
        }
        return "";
    }
}
