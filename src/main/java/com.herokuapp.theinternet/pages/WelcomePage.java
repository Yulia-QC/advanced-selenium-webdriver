package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {

    private String pageUrl = "http://the-internet.herokuapp.com/";
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");
    private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
    private By editorLinkLocator = By.linkText("WYSIWYG Editor");
    private By keyPressesLinkLocator = By.linkText("Key Presses");
    private By upploadLinkLocator = By.linkText("File Upload");

    public WelcomePage(WebDriver driver, Logger log) {

        super(driver,log);
    }

    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }

    public LoginPage clickFromAuthenticationLink() {
        log.info("Clicking From Authentication link on Welcome Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }
    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking Checkboxes link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver,log);
    }
    public DropdownPage clickDropdownLink() {
        log.info("Clicking Dropdown link on Welcome Page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver,log);
    }
    public JavaScriptAlertsPage clickJavaScriptAlertsLink() {
        log.info("Clicking Dropdown link on Welcome Page");
        click(javaScriptAlertsLinkLocator);
        return new JavaScriptAlertsPage(driver,log);
    }

    public WindowsPage clickMultipleWindowsLink(){
        log.info("Clicking Multiple Windows link on Welcome Page");
        click(multipleWindowsLinkLocator);
        return new WindowsPage(driver,log);

    }
    public EditorPage clickEditorLinkLocator(){
        log.info("Clicking Multiple Windows link on Welcome Page");
        click(editorLinkLocator);
        return new EditorPage(driver,log);

    }
    public KeyPressesPage clickKeyPressesPageLinkLocator(){
        log.info("Clicking Multiple Windows link on Welcome Page");
        click(keyPressesLinkLocator);
        return new KeyPressesPage(driver,log);

    }
    public UploadPage clickUploadPageLinkLocator(){
        log.info("Clicking Multiple Windows link on Welcome Page");
        click(upploadLinkLocator);
        return new UploadPage(driver,log);

    }

}
