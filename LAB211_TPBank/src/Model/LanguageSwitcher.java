package Model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.Properties;


public class LanguageSwitcher {
    private Properties properties;
    
    public void setLocate(String locate) {
        try {
            properties = new Properties();
            String path = Paths.get("").toAbsolutePath().toString();
            InputStream inputStream = new FileInputStream(path + "/src/Data/Language_" + locate + ".properties");
            properties.load(new InputStreamReader(inputStream, "UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String translate(String key) {
        return properties.getProperty(key);
    }
    
}
