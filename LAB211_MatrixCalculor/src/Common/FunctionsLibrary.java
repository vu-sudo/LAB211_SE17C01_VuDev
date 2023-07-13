package Common;

public class FunctionsLibrary {
    private InputsLibrary inputsLibrary = new InputsLibrary();

    public int[][] addMatrix(int[][] matrix1, int[][] matrix2) throws Exception {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            // boolean passed = false;
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }

        int rows = matrix1.length;
        int columns = matrix1[0].length;

        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public int[][] subtractMatrix(int[][] matrix1, int[][] matrix2) throws Exception {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Matrix dimensions do not match.");
        }

        int rows = matrix1.length;
        int columns = matrix1[0].length;

        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        return result;
    }

    public int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) throws Exception {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int rows2 = matrix2.length;
        int columns2 = matrix2[0].length;

        if (columns1 != rows2) {
            throw new IllegalArgumentException("Invalid matrix dimensions for multiplication.");
        }

        int[][] result = new int[rows1][columns2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                for (int k = 0; k < columns1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public int[][] readMatrix(String message, int rows, int columns) {
        System.out.println(message);

        int[][] matrix = new int[rows][columns];

        System.out.println("Enter the matrix elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = inputsLibrary
                        .inputValue("You are entering element at row " + (i + 1) + " column " + (j + 1) + ": ");
            }
        }
        return matrix;

    }

    public void printMatrix(String msg, int[][] matrix) {
        System.out.println(msg);
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
