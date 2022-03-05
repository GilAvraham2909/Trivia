package com.trivia.champion;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;


import static com.trivia.champion.utils.Constants.PROPERTIES_FILE_NAME;

public class AppConfig {
    public static int numOfCategoryOptions = 0;
    public static Properties props = new Properties();

    public static void setProperty(String key, String value) throws IOException {
        props.setProperty(key, value);
        props.storeToXML(new FileOutputStream(PROPERTIES_FILE_NAME), "");
    }

    public static String loadProperty(String key) throws IOException {
        try {
            // Load Settings
            props.loadFromXML(new FileInputStream("settings.xml"));
            return props.getProperty(key);
        } catch (IOException exception) {
            return null;
        }
    }


    public static <T> int indexOf(T[] arr, T val) {
        return Arrays.asList(arr).indexOf(val);
    }

}
