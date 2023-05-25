package Model;

public class Item {
	private String product;
	private Integer quantity;
	private Integer price;
	private Integer amount;
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Item(String product, Integer quantity, Integer price) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.calculateAmount();
	}
	
	public Integer calculateAmount() {
		this.amount = (Integer) (this.quantity * this.price);
		return this.amount;
	}
}
