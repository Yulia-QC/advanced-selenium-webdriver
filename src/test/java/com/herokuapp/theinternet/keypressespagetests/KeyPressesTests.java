package com.herokuapp.theinternet.keypressespagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class KeyPressesTests extends TestUtilities {
    @Test
    public void pressKeyTest() {
        log.info("Starting pressKeyTest");

        //open KetPressPage
        KeyPressesPage keyPressesPage = new KeyPressesPage(driver,log);
        keyPressesPage.openPage();
        //Push keyboard key
        keyPressesPage.pressKey(Keys.ENTER);
        //get result text
        String result = keyPressesPage.getResultText();
        //Verify Result text is expected
        Assert.assertTrue(result.equals("You entered: ENTER"),
                "result is not expected. \nShould be 'You entered: ENTER', but trere is: " + result);
    }
    @Test
    public void pressKeyWithActionsTest() {
        log.info("Starting pressKeyWithActionsTest");

        //open KeyPressPage
        KeyPressesPage keyPressesPage = new KeyPressesPage(driver,log);
        keyPressesPage.openPage();
        //Push keyboard key
        keyPressesPage.pressKeyWithActions(Keys.SPACE);
        //get result text
        String result = keyPressesPage.getResultText();
        //Verify Result text is expected
        Assert.assertTrue(result.equals("You entered: SPACE"),
                "result is not expected. \nShould be 'You entered: SPACE', but trere is: " + result);
    }
}
