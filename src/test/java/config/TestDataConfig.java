package config;


import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestDataConfig {
    private static final ISettingsFile TESTDATA = new JsonSettingsFile("testData.json");

    public static String getPath() {
        return TESTDATA.getValue("/relative_Path").toString();
    }
}
