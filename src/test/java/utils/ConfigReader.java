package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = new Properties();

    static {
        try {
            FileInputStream file = new FileInputStream("config.properties");
            prop.load(file);
            file.close();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public static String getProp(String key){
        return prop.getProperty(key);
    }
}
