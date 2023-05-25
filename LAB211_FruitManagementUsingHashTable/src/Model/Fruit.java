package Model;

public class Fruit {
	private String fruitId;
	private String fruitName;
	private Integer price;
	private Integer quantity;
	private String origin;
	public String getFruitId() {
		return fruitId;
	}
	public void setFruitId(String fruitId) {
		this.fruitId = fruitId;
	}
	public String getFruitName() {
		return fruitName;
	}
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public Fruit(String fruitId, String fruitName, Integer price,Integer quantity,  String origin) {
		super();
		this.fruitId = fruitId;
		this.fruitName = fruitName;
		this.price = price;
		this.quantity = quantity;
		this.origin = origin;
	}
	
	
}
