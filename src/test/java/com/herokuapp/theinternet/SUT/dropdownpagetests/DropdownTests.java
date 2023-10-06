package com.herokuapp.theinternet.SUT.dropdownpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTests extends TestUtilities {
    @Test
    public void optionTwoTest() {
        log.info("Starting optionTwoTest");

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver,log);
        welcomePage.openPage();
        //click on Dropdown link
        DropdownPage dropdownPage = welcomePage.clickDropdownLink();

        //Select Option 2
        dropdownPage.selectOption(2);

        //Verify Option 2 selected
        String selectedOption = dropdownPage.getSelectedOption();
        Assert.assertTrue(selectedOption.equals("Option 2"), "Option 2 is not selected - " + selectedOption);
    }
}
