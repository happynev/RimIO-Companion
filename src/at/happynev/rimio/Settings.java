package at.happynev.rimio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings extends Properties {
    private final static File settingsFile = new File("settings.properties");
    private static Settings instance;

    private Settings(Properties defaults) {
        super(defaults);
    }

    private Settings() {

        if (settingsFile.exists() && settingsFile.canRead()) {
            try {
                FileInputStream fis = new FileInputStream(settingsFile);
                this.load(fis);
                fis.close();
            } catch (IOException e) {
                System.err.println("cannot read " + settingsFile.toString());
            }
        } else {
            saveToFile();
        }
    }

    public static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }

    @Override
    public synchronized Object setProperty(String key, String value) {
        //System.out.println("set " + key + "=" + value);
        Object ret = super.setProperty(key, value);
        saveToFile();
        return ret;
    }

    private void saveToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(settingsFile);
            this.store(fos, "auto generated and saved on change. do not edit while RimIO is open. expect errors if you enter stupid values");
            fos.close();
        } catch (IOException e) {
            System.err.println("cannot save settings to " + settingsFile.toString() + ": " + e.getMessage());
        }
    }
}
