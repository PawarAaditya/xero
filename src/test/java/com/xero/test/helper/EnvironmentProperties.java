package com.xero.test.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class EnvironmentProperties extends Properties {

    private static final long serialVersionUID = 1L;


    public EnvironmentProperties() {

    }

    public String getCurrentEnvironmentName() {
        Properties propMainEnvFile = new Properties();
        InputStream inputStreamMain = Thread.currentThread().getContextClassLoader().getResourceAsStream("env.properties");
        try {
            propMainEnvFile.load(inputStreamMain);
        } catch(FileNotFoundException e) {

        } catch(IOException e) {

        }
        String currentEnvironment = System.getProperty("env");

        if (currentEnvironment==null || currentEnvironment=="")
        {
            currentEnvironment = propMainEnvFile.getProperty("environment.to.be.used");
        }
        return currentEnvironment;
    }


    public String getProperty(String key) {
        String currentEnvironment = getCurrentEnvironmentName()+ ".properties";;
        Properties properties = new Properties();
        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(currentEnvironment);

        try {
            properties.load(inputStream);
            inputStream.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
        String value = properties.getProperty(key);
        return value;
    }
}
