package Model;

public class SimpleComputer {
    private Double number;
    private String operator;
    private Double memory;
    private Double result;

    public Double getNumber() {
        return number;
    }

    public String getOperator() {
        return operator;
    }

    public Double getMemory() {
        return memory;
    }

    public Double getResult() {
        return result;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setMemory(Double memory) {
        this.memory = memory;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public SimpleComputer() {
        super();
    }
    public SimpleComputer(Double number, String operator, Double memory, Double result) {
        this.number = number;
        this.operator = operator;
        this.memory = memory;
        this.result = result;
    }

    @Override
    public String toString() {
        return "SimpleComputer [number=" + number + ", operator=" + operator + ", memory=" + memory + ", result="
                + result + "]";
    }
}
