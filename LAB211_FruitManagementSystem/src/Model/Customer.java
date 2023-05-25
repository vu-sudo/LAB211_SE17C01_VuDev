package Model;

import java.util.ArrayList;

public class Customer {
    private String customerName;
    private Integer customerTotalOfBill;
    private ArrayList<FruitOrdered> customeFruitOrders;

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setCustomerTotalOfBill(Integer customerTotalOfBill) {
        this.customerTotalOfBill = customerTotalOfBill;
    }
    public void setCustomeFruitOrders(ArrayList<FruitOrdered> customeFruitOrders) {
        this.customeFruitOrders = customeFruitOrders;
    }
    public String getCustomerName() {
        return customerName;
    }
    public Integer getCustomerTotalOfBill() {
        return customerTotalOfBill;
    }
    public ArrayList<FruitOrdered> getCustomeFruitOrders() {
        return customeFruitOrders;
    }
    public Customer(String customerName, Integer customerTotalOfBill) {
        this.customerName = customerName;
        this.customerTotalOfBill = customerTotalOfBill;
        this.customeFruitOrders = new ArrayList<FruitOrdered>();
    }
    public void addItemToFruitOrder(FruitOrdered fruitOrdered) {
        customeFruitOrders.add(fruitOrdered);
    }
    public void removeItemFromFruitOrder(FruitOrdered fruitOrdered) {
        customeFruitOrders.remove(fruitOrdered);
    }
    @Override
    public String toString() {
        return "Customer [customerName=" + customerName + ", customerTotalOfBill=" + customerTotalOfBill
                + ", customeFruitOrders=" + customeFruitOrders + "]";
    }
    
}
