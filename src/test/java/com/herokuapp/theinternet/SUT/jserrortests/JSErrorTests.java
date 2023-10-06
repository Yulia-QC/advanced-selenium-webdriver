package com.herokuapp.theinternet.SUT.jserrortests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JSErrorPage;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class JSErrorTests extends TestUtilities {
    @Test(enabled = false)
    public void jsErrorTest() {
        log.info("Starting jsErrorTest");
        SoftAssert softAssert = new SoftAssert();

        //open JSErrorPage
        JSErrorPage jsErrorPage = new JSErrorPage(driver,log);
        jsErrorPage.openPage();
        //get logs
        List<LogEntry> logs = getBrowserLogs();

        //verify there are no JavaScript errors in console
        for(LogEntry logEntry : logs) {
            if(logEntry.getLevel().toString().equals("SEVERE")) {
                softAssert.fail("Severe error: " + logEntry.getMessage());
            }
        }
        softAssert.assertAll();
    }


}
