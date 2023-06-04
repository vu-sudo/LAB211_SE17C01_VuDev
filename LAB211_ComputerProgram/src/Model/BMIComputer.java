package Model;

public class BMIComputer {
    private Double bodyWeight;
    private Double height;
    private Double bmiNumber;

    private String status;

    public void setBodyWeight(Double bodyWeight) {
        this.bodyWeight = bodyWeight;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public Double getBodyWeight() {
        return bodyWeight;
    }
    public Double getHeight() {
        return height;
    }

    public String getStatus() {
        return status;
    }
    public void setBmiNumber(Double bmiNumber) {
        this.bmiNumber = bmiNumber;
    }
    public Double getBmiNumber() {
        return bmiNumber;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public BMIComputer() {
        super();
    }

    @Override
    public String toString() {
        return "BMIComputer [bodyWeight=" + bodyWeight + ", height=" + height + "]";
    }
    
}
