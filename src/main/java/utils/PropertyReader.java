package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Admin on 24.04.2016.
 */
public class PropertyReader {

    public static String getProperty(String property) {

        Properties prop = new Properties();
        InputStream input = null;

        try {
            String filename = "config.properties";
            input = PropertyReader.class.getClassLoader().getResourceAsStream(filename);
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return prop.getProperty(property);
    }

}
