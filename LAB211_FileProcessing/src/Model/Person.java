package Model;

public class Person {
    private String name;
    private String address;
    private Double money;

    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public Double getMoney() {
        return money;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setMoney(Double money) {
        this.money = money;
    }
    public Person(String name, String address, Double money) {
        this.name = name;
        this.address = address;
        this.money = money;
    }
    @Override
    public String toString() {
        return this.name;
    }
}
