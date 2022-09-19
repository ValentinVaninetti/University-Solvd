package com.solvd.utils;

import java.io.*;
import java.util.Properties;

public class CommonUtils {

    /**
     * This method is used to read properties from the properties file.
     *
     * @param filePath
     * @param key
     * @return String: value
     * @throws IOException
     */
    public static String readPropertiesFile(String filePath, String key) throws IOException {
        FileReader reader = new FileReader(filePath);
        Properties properties = new Properties();
        properties.load(reader);
        return properties.getProperty(key);
    }
}
