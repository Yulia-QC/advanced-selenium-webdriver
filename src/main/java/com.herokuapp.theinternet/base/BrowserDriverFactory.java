package com.herokuapp.theinternet.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class BrowserDriverFactory {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private String browser;
    private Logger log;

    public BrowserDriverFactory(String browser, Logger log) {

        this.browser = browser.toLowerCase();
        this.log = log;
    }

    public WebDriver createDriver() {
        log.info("Create driver: " + browser);

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
                driver.set(new FirefoxDriver());
                break;

            default:
                System.out.println("Do not know how to start: " + browser + ", starting chrome.");
                System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
                driver.set(new ChromeDriver());
                break;
        }
        return driver.get();
        }

        public WebDriver createChromeWithProfile(String profile) {
        log.info("Starting chrome driver with profile: " + profile);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("C:\\Users\\yteren\\IdeaProjects\\advancedSelenium\\src\\main\\resources\\Profiles" + profile);
            System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
            driver.set(new ChromeDriver(chromeOptions));
            return driver.get();
        }
        public WebDriver createChromeWithMobileEmulation(String deviceName) {
        log.info("Starting driver with " + deviceName + " emulation]");
            Map<String,String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", deviceName);
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
            driver.set(new ChromeDriver(chromeOptions));
            return driver.get();
        }
    }

