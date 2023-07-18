package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;
import lombok.SneakyThrows;

public class Config {

    private final File appConfig;
    private final Properties properties;

    @SneakyThrows
    public Config() {
        String path = isCreated();
        System.out.println(path);
        assert path != null;
        File appConfig = new File(path);
        FileInputStream propsInput = new FileInputStream(path);
        Properties prop = new Properties();
        prop.load(propsInput);
        this.appConfig = appConfig;
        this.properties = prop;
    }

    private String isCreated() {
        try {
            File myObj = new File("config.yml");
            if (myObj.createNewFile()) {
            } else {
            }
            return myObj.getPath();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    @SneakyThrows
    public boolean write(String key, String value) {
        try (Writer inputStream = new FileWriter(this.appConfig)) {
            this.properties.setProperty(key, value);
            this.properties.store(inputStream,"Last change:");
            inputStream.close();
            return true;
        } catch (IOException ex) {
            throw new Exception("Write config error");
        }
    }

    @SneakyThrows
    public String read(String key) {
        try (Reader ignored = new FileReader(this.appConfig)) {
            return this.properties.getProperty(key);
        } catch (IOException ex) {
            throw new Exception("Read config error");
        }
    }
}