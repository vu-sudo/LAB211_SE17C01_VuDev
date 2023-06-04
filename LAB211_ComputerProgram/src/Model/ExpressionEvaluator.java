package Model;
import java.util.*;

public class ExpressionEvaluator {
    private static final Map<Character, Integer> OPERATOR_PRECEDENCE = new HashMap<>();
    static {
        OPERATOR_PRECEDENCE.put('+', 1);
        OPERATOR_PRECEDENCE.put('-', 1);
        OPERATOR_PRECEDENCE.put('*', 2);
        OPERATOR_PRECEDENCE.put('/', 2);
        OPERATOR_PRECEDENCE.put('^', 3);
    }

    public double evaluateExpression(String expression) {
        List<String> postfixExpression = convertToPostfix(expression);
        return evaluatePostfix(postfixExpression);
    }

    private List<String> convertToPostfix(String expression) {
        List<String> postfixExpression = new ArrayList<>();
        Stack<Character> operatorStack = new Stack<>();

        StringTokenizer tokenizer = new StringTokenizer(expression, "+-*/^()", true);
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();

            if (token.isEmpty()) {
                continue;
            }

            char currentChar = token.charAt(0);

            if (Character.isDigit(currentChar)) {
                postfixExpression.add(token);
            } else if (currentChar == '(') {
                operatorStack.push(currentChar);
            } else if (currentChar == ')') {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                    postfixExpression.add(operatorStack.pop().toString());
                }
                if (!operatorStack.isEmpty() && operatorStack.peek() == '(') {
                    operatorStack.pop();
                } else {
                    throw new IllegalArgumentException("Invalid expression: Unbalanced parentheses");
                }
            } else if (isOperator(currentChar)) {
                while (!operatorStack.isEmpty() && operatorStack.peek() != '(' &&
                        hasHigherPrecedence(currentChar, operatorStack.peek())) {
                    postfixExpression.add(operatorStack.pop().toString());
                }
                operatorStack.push(currentChar);
            } else {
                throw new IllegalArgumentException("Invalid character encountered: " + currentChar);
            }
        }

        while (!operatorStack.isEmpty()) {
            char operator = operatorStack.pop();
            if (operator == '(') {
                throw new IllegalArgumentException("Invalid expression: Unbalanced parentheses");
            }
            postfixExpression.add(Character.toString(operator));
        }

        return postfixExpression;
    }

    private double evaluatePostfix(List<String> postfixExpression) {
        Stack<Double> operandStack = new Stack<>();

        for (String token : postfixExpression) {
            if (isNumeric(token)) {
                operandStack.push(Double.parseDouble(token));
            } else if (isOperator(token.charAt(0))) {
                double operand2 = operandStack.pop();
                double operand1 = operandStack.pop();
                double result = applyOperation(token.charAt(0), operand1, operand2);
                operandStack.push(result);
            } else {
                throw new IllegalArgumentException("Invalid token encountered: " + token);
            }
        }

        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: Malformed");
        }

        return operandStack.pop();
    }

    private boolean isOperator(char ch) {
        return OPERATOR_PRECEDENCE.containsKey(ch);
    }

    private boolean hasHigherPrecedence(char op1, char op2) {
        return OPERATOR_PRECEDENCE.get(op1) > OPERATOR_PRECEDENCE.get(op2);
    }

    private double applyOperation(char operator, double operand1, double operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Invalid expression: Division by zero");
                }
                return operand1 / operand2;
            case '^':
                return Math.pow(operand1, operand2);
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}

