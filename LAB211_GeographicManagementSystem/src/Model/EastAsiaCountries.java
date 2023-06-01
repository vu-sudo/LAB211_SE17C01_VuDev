package Model;

public class EastAsiaCountries extends Country {
    private String countryTerrain;

    public EastAsiaCountries(String countryCode, String countryName, Double totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }
    
    public EastAsiaCountries(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    @Override
    public String toString() {
        return super.toString() +  "EastAsianCountries [countryTerrain=" + countryTerrain + "]";
    }
    
}
