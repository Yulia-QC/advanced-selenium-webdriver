package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//test commit
public class WindowsPage extends BasePageObject {
    private By clickHereLinkLocator = By.xpath("//a[@href='/windows/new']");


    public WindowsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openNewWindow() {
        log.info("Clicking 'Click Here' link");
        click(clickHereLinkLocator);

    }

    public NewWindowPage switchToNewWindowPage() {
        log.info("Looking for 'New Window' page");
        switchToWindowWithTitle("New Window");
        return new NewWindowPage(driver, log);

    }

}
