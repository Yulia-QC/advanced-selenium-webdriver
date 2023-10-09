package com.herokuapp.theinternet.SUT.loginpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import io.qameta.allure.Description;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends TestUtilities {
    @Description("Main test")
    @Test
    public void logInTest() {

        // open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        takeScreenshot("WelcomePage opened");

        // Click on Form Authentication link
        LoginPage loginPage = welcomePage.clickFromAuthenticationLink();
        takeScreenshot("LoginPage opened");

        //add new cookie
        Cookie ck = new Cookie("username","tomsmith","the-internet.herokuapp.com","/",null);
        loginPage.setCookie(ck);

        // execute log in
        SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");
        takeScreenshot("SecureAreaPage opened");

        //get cookies
        String username = secureAreaPage.getCookie("username");
        log.info("Username cookie: " + username);
        String session = secureAreaPage.getCookie("rack.session");
        log.info("Session cookie: " + session);


        // verifications:
        // new url
        Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

        // log out button is visible
        Assert.assertTrue(secureAreaPage.isLogOutButtonVisisble(), "LogOut Button is not visible.");

        // Successful log in message
        String expectedSuccessMessage = "You logged into a secure area!";
        String actualSuccessMessage = secureAreaPage.getSuccessMessageText();
        Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
                "actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
                        + expectedSuccessMessage + "\nactualSuccessMessage: " + actualSuccessMessage);

    }
}
