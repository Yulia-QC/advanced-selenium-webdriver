package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject {
    private String pageUrl = "http://the-internet.herokuapp.com/drag_and_drop";
    private By columnALocator = By.id("column-a");
    private By columnBLocator = By.id("column-b");
    public DragAndDropPage(WebDriver driver, Logger log) {
        super(driver, log);
    }
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }
    public void dragAToB() {
        log.info("Drag and drop A box on B box");
        performDragAndDrop(columnALocator, columnBLocator);

    }
    public String getColumnAText() {
        String text = find(columnALocator).getText();
        log.info("Column A Text: " + text);
        return text;
    }
    public String getColumnBText() {
        String text = find(columnBLocator).getText();
        log.info("Column B Text: " + text);
        return text;
    }

}
