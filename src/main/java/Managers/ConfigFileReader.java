package Managers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class ConfigFileReader {

    public Properties properties;

    public  ConfigFileReader(String propertyFilePath){
        try{
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(propertyFilePath));
            this.properties = new Properties();
            this.properties.load(reader);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
