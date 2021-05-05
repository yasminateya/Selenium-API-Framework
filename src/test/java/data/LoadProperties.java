package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

    //load properties file from the folder
    public static Properties userData = loadProperties(System.getProperty(("user.dir") + ("/src/main/java/properties/userdata.properties")));

    private static Properties loadProperties(String path) {

        Properties properties = new Properties();

        try {
            FileInputStream fileInputStream = new FileInputStream(path); //class obtains input bytes from a file. It is used for reading byte-oriented data
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            System.out.println("Error in fileInputStream: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Can't load properties file: " + e.getMessage());
        }
        return properties;
    }


}
