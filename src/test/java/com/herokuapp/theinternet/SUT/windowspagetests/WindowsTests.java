package com.herokuapp.theinternet.SUT.windowspagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.WindowsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowsTests extends TestUtilities {
    @Test
    public void newWindowTest() {
        log.info("Starting newWindowTest");
        //open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        //click on MultipleWindows link
        WindowsPage windowsPage = welcomePage.clickMultipleWindowsLink();

        //click 'Click Here' link to open new window
        windowsPage.openNewWindow();

        //find and switch to new window page
        NewWindowPage newWindowPage = windowsPage.switchToNewWindowPage();

        String pageSource = newWindowPage.getCurrentPageSource();
        //verification that new page contains expected text in source
        Assert.assertTrue(pageSource.contains("New Window"), "New page source doesn't met");
    }
}
