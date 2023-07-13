package Controller;

import Common.FunctionsLibrary;
import Common.InputsLibrary;

public class MatrixCalculatorController {
    private final FunctionsLibrary functionsLibrary = new FunctionsLibrary();
    private final InputsLibrary inputsLibrary = new InputsLibrary();

    public void handleAddMatrix() {
        boolean passed = false;
        int rows = inputsLibrary.inputValue("Enter number of rows: ");
        int columns = inputsLibrary.inputValue("Enter number of columns: ");
        int[][] matrix1, matrix2, resultMatrix;
        do {
            try {
                matrix1 = functionsLibrary.readMatrix("ENTERING MATRIX 1:", rows, columns);
                // functionsLibrary.printMatrix(matrix1);
                matrix2 = functionsLibrary.readMatrix("ENTERING MATRIX 2: ", rows, columns);
                resultMatrix = functionsLibrary.addMatrix(matrix1, matrix2);
                passed = true;
                if (passed == true) {
                    functionsLibrary.printMatrix("=============ADDITION RESULT=============",resultMatrix);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                passed = false;
            }
        } while (passed = false);
    }

    public void handleSubtractMatrix() {
        boolean passed = false;
       int rows = inputsLibrary.inputValue("Enter number of rows: ");
        int columns = inputsLibrary.inputValue("Enter number of columns: ");
        int[][] matrix1, matrix2, resultMatrix;
        do {
            try {
                matrix1 = functionsLibrary.readMatrix("ENTERING MATRIX 1:", rows, columns);
                // functionsLibrary.printMatrix(matrix1);
                matrix2 = functionsLibrary.readMatrix("ENTERING MATRIX 2: ", rows, columns);
                resultMatrix = functionsLibrary.subtractMatrix(matrix1, matrix2);
                passed = true;
                if (passed == true) {
                    functionsLibrary.printMatrix("=============SUBTRACTION RESULT=============",resultMatrix);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                passed = false;
            }
        } while (passed = false);
    }

    public void handleMultiplyMatrix() {
        boolean passed = false;
        int rows = inputsLibrary.inputValue("Enter number of rows (matrix 1) / columns (matrix 2): ");
        int columns = inputsLibrary.inputValue("Enter number of columns (matrix 2) / rows (matrix 1): ");
        int[][] matrix1, matrix2, resultMatrix;
        do {
            try {
                matrix1 = functionsLibrary.readMatrix("ENTERING MATRIX 1:", rows, columns);
                // functionsLibrary.printMatrix(matrix1);
                matrix2 = functionsLibrary.readMatrix("ENTERING MATRIX 2: ", columns, rows);
                resultMatrix = functionsLibrary.multiplyMatrix(matrix1, matrix2);
                passed = true;
                if (passed == true) {
                    functionsLibrary.printMatrix("=============MULTIPLYING RESULT=============",resultMatrix);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                passed = false;
            }
        } while (passed = false);
    }
}
