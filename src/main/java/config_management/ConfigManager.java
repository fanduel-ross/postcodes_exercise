package config_management;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static final Properties config;

    static {
        config = new Properties();
        try {
            config.load(new FileReader("src/test/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static String postcodesBaserUrl() {
        return config.getProperty("base_url");
    }

    public static String postcodesEndpoint() {
        return config.getProperty("postcodes_endpoint");
    }

    public static String postcodeTestFileLocation() {
        return config.getProperty("postcode_test_file_location");
    }



}
