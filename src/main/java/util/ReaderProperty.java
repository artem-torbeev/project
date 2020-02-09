package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReaderProperty {

    public String getTypeConnectionDAO(){

        InputStream inputStream = ReaderProperty.class.getResourceAsStream("/db_type_connection.properties");
        Properties properties = new Properties();
        String result = "";
        try {
            if (inputStream == null) return null;
            properties.load(inputStream);
            result = properties.getProperty("db_type_connection");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
