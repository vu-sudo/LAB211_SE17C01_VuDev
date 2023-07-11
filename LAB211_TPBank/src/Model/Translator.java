package Model;


public class Translator {

    static String language = "en";

    private LanguageSwitcher languageSwicher;
    
    public Translator() {
        super();
        this.languageSwicher = new LanguageSwitcher();
        this.languageSwicher.setLocate(language);
    }

    public Translator(String languageBundle) {
        super();
        language = languageBundle;
        this.languageSwicher = new LanguageSwitcher();
        this.languageSwicher.setLocate(language);
    }

    public void setLanguageSwitcherLocale(String langugeBundle) {
        language = langugeBundle;
        this.languageSwicher.setLocate(language); 
    }

    public String getBundle() {
        return language;
    }

    public String translate(String key) {
        setLanguageSwitcherLocale(language);
        return languageSwicher.translate(key);
    }

    @Override
    public String toString() {
        return "SRC: " + language;
    }
}
