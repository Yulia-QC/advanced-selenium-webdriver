package com.herokuapp.theinternet.pages;

import com.herokuapp.theinternet.base.PathUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class UploadPage extends BasePageObject{
    private String pageUrl = "http://the-internet.herokuapp.com/upload";

    private By choseFileLocator = By.id("file-upload");
    private By uploadButtonLocator = By.id("file-submit");
    private By uploadFilesLocator = By.id("uploaded-files");
    public UploadPage(WebDriver driver, Logger log) {

        super(driver, log);
    }
    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
    }
    public void selectFile(String fileName){
        log.info("Selecting '" + fileName + "' file from Files folder.");
        String filePath = PathUtils.getFullPath("/files/"+fileName);
        type(filePath,choseFileLocator);
        log.info("File selected");

    }
    public void pushUploadButton() {
        log.info("Pushing  the upload button.");
        click(uploadButtonLocator);
    }
    public String getUploadedFilesNames() {
        log.info("Getting the uploaded files name");
        String names = find(uploadFilesLocator).getText();
        return names;
    }
}
