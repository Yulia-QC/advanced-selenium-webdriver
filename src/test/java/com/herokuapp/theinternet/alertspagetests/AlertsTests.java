package com.herokuapp.theinternet.alertspagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertsTests extends TestUtilities {
    @Test
    public void jsAlertTest(){

        SoftAssert softAssert = new SoftAssert();

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();
        //click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
        //click JS Alert button
        alertsPage.openJSAlert();
        //get alert text
        String alertMessage = alertsPage.getAlertText();
        //click OK button
        alertsPage.acceptAlert();
        //get result text
        String result = alertsPage.getResultText();

        //Verifications:
        //1 - Alert text is expected
        softAssert.assertTrue(alertMessage.equals("I am a JS Alert"),
                "Alert message is not as expected. \nShould be 'I am JS Alert', but now " + alertMessage);
        //2 - Result text is expected
        softAssert.assertTrue(result.equals("You successfully clicked an alert"),
                "result is not as expected. \nShould be 'You successfully clicked an alert', but now " + result);
        softAssert.assertAll();


    }
    @Test
    public void jsConfirmTest(){

        SoftAssert softAssert = new SoftAssert();
        //open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();
        //click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
        //click JS Confirm button
        alertsPage.openJSConfirm();
        //get alert text
        String alertMessage = alertsPage.getAlertText();
        //click OK button
        alertsPage.acceptAlert();
        //get result text
        String result = alertsPage.getResultText();

        //Verifications:
        //1 - Alert text is expected
        softAssert.assertTrue(alertMessage.equals("I am a JS Confirm"),
                "Alert message is not as expected. \nShould be 'I am JS Confirm', but now " + alertMessage);
        //2 - Result text is expected
        softAssert.assertTrue(result.equals("You clicked: Ok"),
                "result is not as expected. \nShould be 'You clicked: Ok', but now " + result);
        softAssert.assertAll();

    }
    @Test
    public void jsDismissTest(){

        SoftAssert softAssert = new SoftAssert();
        //open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();
        //click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
        //click JS Confirm button
        alertsPage.openJSConfirm();
        //get alert text
        String alertMessage = alertsPage.getAlertText();
        //click OK button
        alertsPage.dismissAlert();
        //get result text
        String result = alertsPage.getResultText();

        //Verifications:
        //1 - Alert text is expected
        softAssert.assertTrue(alertMessage.equals("I am a JS Confirm"),
                "Alert message is not as expected. \nShould be 'I am JS Confirm', but now " + alertMessage);
        //2 - Result text is expected
        softAssert.assertTrue(result.equals("You clicked: Cancel"),
                "result is not as expected. \nShould be 'You clicked: Cancel', but now " + result);
        softAssert.assertAll();

    }
    @Test
    public void jsPromptTest(){

        SoftAssert softAssert = new SoftAssert();
        //open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();
        //click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();
        //click JS Alert button
        alertsPage.openJSPrompt();
        //get alert text
        String alertMessage = alertsPage.getAlertText();
        //type text into alert
        alertsPage.typeTextIntoAlert("Hello Alert, it's I am!");
        //get result text
        String result = alertsPage.getResultText();

        //Verifications:
        //1 - Alert text is expected
        softAssert.assertTrue(alertMessage.equals("I am a JS prompt"),
                "Alert message is not as expected. \nShould be 'I am JS prompt', but now " + alertMessage);
        //2 - Result text is expected
        softAssert.assertTrue(result.equals("You entered: Hello Alert, it's I am!"),
                "result is not as expected. \nShould be 'You entered: Hello Alert, it's I am!', but now " + result);
        softAssert.assertAll();


    }


}
