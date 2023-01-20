package org.fasttrackit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static Properties properties = new Properties();

    static {
        InputStream inputStream = AppConfig.class.getClassLoader().getResourceAsStream("production.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Failed to load properties");
        }
    }

    private static String chromeDriverPath = properties.getProperty("chrome.driver.path");
    private static String geckoDriverPath = properties.getProperty("gecko.driver.path");
    private static String siteUrl = properties.getProperty("site.url");

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        AppConfig.properties = properties;
    }

    public static String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public static void setChromeDriverPath(String chromeDriverPath) {
        AppConfig.chromeDriverPath = chromeDriverPath;
    }

    public static String getGeckoDriverPath() {
        return geckoDriverPath;
    }

    public static void setGeckoDriverPath(String geckoDriverPath) {
        AppConfig.geckoDriverPath = geckoDriverPath;
    }

    public static String getSiteUrl() {
        return siteUrl;
    }

    public static void setSiteUrl(String siteUrl) {
        AppConfig.siteUrl = siteUrl;
    }
}
