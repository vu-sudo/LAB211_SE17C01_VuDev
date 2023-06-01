package Model;

public abstract class Country {
    protected String countryCode;
    protected String countryName;
    protected Double totalArea;
    
    public String getCountryCode() {
        return countryCode;
    }
    public String getCountryName() {
        return countryName;
    }
    public Double getTotalArea() {
        return totalArea;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }
    public Country(String countryCode, String countryName, Double totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }
    public Country() {
        super();
    }
    
}
