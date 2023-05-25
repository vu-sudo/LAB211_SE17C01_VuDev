package Model;

public class FruitOrdered {
    private String productName;
    private Integer productQuantity = 0;
    private Integer productPrice = 0;
    private Integer amount = 0;
    
    public String getProductName() {
        return productName;
    }
    public Integer getProducQuantity() {
        return productQuantity;
    }
    public Integer getProducPrice() {
        return productPrice;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public void setProducQuantity(Integer producQuantity) {
        this.productQuantity = producQuantity;
    }
    public void setProducPrice(Integer producPrice) {
        this.productPrice = producPrice;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public FruitOrdered(String productName, Integer producQuantity, Integer productPrice, Integer amount) {
        this.productName = productName;
        this.productQuantity = producQuantity;
        this.productPrice = productPrice;
        this.amount = amount;
    }
    public FruitOrdered() {
        super();
    }
    public void calculateAmount() {
        this.amount = this.productQuantity*this.productPrice;
    }
    @Override
    public String toString() {
        return "FruitOrdered [productName=" + productName + ", productQuantity=" + productQuantity + ", productPrice="
                + productPrice + ", amount=" + amount + "]";
    }
    
}
