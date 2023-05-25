package Model;

public class Fruit {
    private String fruitId;
    private String fruitName;
    private Integer fruitPrice;
    private Integer fruitQuantity;
    private String fruitOrigin;
    
    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }
    public void setFruitQuantity(Integer fruitQuantity) {
        this.fruitQuantity = fruitQuantity;
    }
    public void setFruitPrice(Integer fruitPrice) {
        this.fruitPrice = fruitPrice;
    }
    public void setFruitOrigin(String fruitOrigin) {
        this.fruitOrigin = fruitOrigin;
    }
    public String getFruitId() {
        return fruitId;
    }
    public String getFruitName() {
        return fruitName;
    }
    public Integer getFruitQuantity() {
        return fruitQuantity;
    }
    public Integer getFruitPrice() {
        return fruitPrice;
    }
    public String getFruitOrigin() {
        return fruitOrigin;
    }
    public Fruit(String fruitId, String fruitName, Integer fruitPrice, Integer fruitQuantity, String fruitOrigin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.fruitPrice = fruitPrice;
        this.fruitQuantity = fruitQuantity;
        this.fruitOrigin = fruitOrigin;
    }
    public Fruit() {
        super();
    }
    @Override
    public String toString() {
        return "Fruit [fruitId=" + fruitId + ", fruitName=" + fruitName + ", fruitPrice=" + fruitPrice
                + ", fruitQuantity=" + fruitQuantity + ", fruitOrigin=" + fruitOrigin + "]";
    }
    
}
