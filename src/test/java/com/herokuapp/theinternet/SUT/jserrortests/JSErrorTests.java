package com.herokuapp.theinternet.SUT.jserrortests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JSErrorPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

public class JSErrorTests extends TestUtilities {
    @Description("This failed as expected")
    @Severity(SeverityLevel.BLOCKER)
    @Test

    public void jsErrorTest() throws FileNotFoundException {
        log.info("Starting jsErrorTest");
        SoftAssert softAssert = new SoftAssert();

        //open JSErrorPage
        JSErrorPage jsErrorPage = new JSErrorPage(driver,log);
        jsErrorPage.openPage();
        //get logs
        List<LogEntry> logs = getBrowserLogs();
        InputStream is = new FileInputStream("C:\\Users\\yteren\\IdeaProjects\\advancedSelenium\\src\\test\\resources\\files\\test.jpg");
        Allure.addAttachment("Screenshot",is);

        //verify there are no JavaScript errors in console
        for(LogEntry logEntry : logs) {
            if(logEntry.getLevel().toString().equals("SEVERE")) {
                softAssert.fail("Severe error: " + logEntry.getMessage());
            }
        }
        softAssert.assertAll();

    }


}
