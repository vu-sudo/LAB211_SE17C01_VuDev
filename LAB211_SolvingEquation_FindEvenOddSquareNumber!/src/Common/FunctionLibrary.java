package Common;

import java.util.Scanner;

public class FunctionLibrary {
    private final Scanner input = new Scanner(System.in);
    Validation validator = new Validation();

    public Double setNumber(String msg, String regex) {
        Double doubleResult = 0.0;
        do {
            try {
                System.out.print(msg);
                doubleResult = Double.parseDouble(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("The Input must be a number!");
            }
        } while (!validator.validatePattern(doubleResult.toString(), regex));
        return doubleResult;
    }
    public boolean isPerfectSquareNumber(Double number) {
        double sqrt = Math.sqrt(number);
        int roundeSqrt = (int) sqrt;
        return (roundeSqrt * roundeSqrt == number);
    }
}
