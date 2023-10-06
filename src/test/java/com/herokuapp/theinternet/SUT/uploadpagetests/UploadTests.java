package com.herokuapp.theinternet.SUT.uploadpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.UploadPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadTests extends TestUtilities {

    @Test(dataProvider = "files")
    public void fileUploadTest(int no, String fileName) {
        log.info("Starting fileUploadTest #" + no + " for" + fileName);
        //open File Upload Page
        UploadPage uploadPage = new UploadPage(driver,log);
        uploadPage.openPage();

        uploadPage.selectFile(fileName);
        //push upload button
        uploadPage.pushUploadButton();
        //get uploaded files
        String fileNames = uploadPage.getUploadedFilesNames();

        //verify selected file uploaded
        Assert.assertTrue(fileNames.contains(fileName),
                "The file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
    }
}
