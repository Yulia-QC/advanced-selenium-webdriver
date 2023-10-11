package com.herokuapp.theinternet.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogEntries;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestUtilities extends BaseTest {

    @DataProvider(name="files")
    protected static Object[][] files() {
        return new Object[][] {
                {1,"index.html"},
                {2,"test.jpg"},
                {3,"text.txt"}
        };
    }

    protected void takeScreenshot(String fileName) {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")
                + File.separator + "target\\test-output"
                + File.separator + "screenshots"
                + File.separator + getTodaysDate()
                + File.separator + testSuiteName
                + File.separator + testName
                + File.separator + testMethodName
                + File.separator + getSystemTime()
                + " " + fileName + ".png";
        try {
            FileUtils.copyFile(srcFile, new File(path));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getSystemTime() {

        return (new SimpleDateFormat("HHmmssSSS").format(new Date()));
    }

    private String getTodaysDate() {
        return (new SimpleDateFormat("yyyyMMdd").format(new Date()));
    }

    protected List<LogEntry> getBrowserLogs() {
        LogEntries log = driver.manage().logs().get("browser");
        List<LogEntry> logList = log.getAll();
        return logList;
    }
}
