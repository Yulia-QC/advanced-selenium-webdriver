package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


    public class JavaScriptAlertsPage extends BasePageObject {
        private By clickForJSAlertLocator = By.xpath("//button[text()='Click for JS Alert']");
        private By clickForJSConfirmLocator = By.xpath("//button[text()='Click for JS Confirm']");
        private By clickForJSPromptLocator = By.xpath("//button[text()='Click for JS Prompt']");
        private By resultTextLocator = By.id("result");

        public JavaScriptAlertsPage(WebDriver driver, Logger log) {
            super(driver, log);
        }
        public void openJSAlert(){
            log.info("Clicking on 'Click for JS Alert' button to open alert");
            click(clickForJSAlertLocator);

        }
        public void openJSConfirm(){
            log.info("Clicking on 'Click for JS Confirm' button to open alert");
            click(clickForJSConfirmLocator);

        }
        public void openJSPrompt(){
            log.info("Clicking on 'Click for JS Prompt' button to open alert");
            click(clickForJSPromptLocator);

        }
        public String getAlertText(){
            Alert alert = switchToAlert();
            String alertText = alert.getText();
            log.info("Alert says: " + alertText);
            return alertText;

        }
        public void acceptAlert(){
            log.info("Switching to alert and presenting OK");
            Alert alert = switchToAlert();
            alert.accept();
        }
        public void dismissAlert(){
            log.info("Switching to alert and presenting Cancel");
            Alert alert = switchToAlert();
            alert.dismiss();
        }
        public void typeTextIntoAlert(String text){
            log.info("Typing text in to alert and presenting OK");
            Alert alert = switchToAlert();
            alert.sendKeys(text);
            alert.accept();
        }
        public String getResultText(){
            String result = find(resultTextLocator).getText();
            log.info("Result text: " + result);
            return result;
        }

}
