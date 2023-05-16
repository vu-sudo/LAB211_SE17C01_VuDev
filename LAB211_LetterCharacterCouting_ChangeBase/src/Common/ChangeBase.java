package Common;

public class ChangeBase {
    public Integer convertToDecimal(String numberStr, int base) {
        if (base == 2) {
            return Integer.parseInt(numberStr, 2);
        } else if (base == 10) {
            return Integer.parseInt(numberStr);
        } else if (base == 16) {
            return Integer.parseInt(numberStr, 16);
        } else {
            throw new IllegalArgumentException("Invalid base: " + base);
        }
    }

    public String convertFromDecimal(int decimalNumber, int targetBase) {
        if (targetBase == 2) {
            return Integer.toBinaryString(decimalNumber);
        } else if (targetBase == 10) {
            return Integer.toString(decimalNumber);
        } else if (targetBase == 16) {
            return Integer.toHexString(decimalNumber).toUpperCase();
        } else {
            throw new IllegalArgumentException("Invalid target base: " + targetBase);
        }
    }

}
