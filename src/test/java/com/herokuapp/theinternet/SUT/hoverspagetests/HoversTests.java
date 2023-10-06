package com.herokuapp.theinternet.SUT.hoverspagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HoversPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoversTests extends TestUtilities {
    @Test
    public void user2ProfileTest() {
        log.info("Starting user2ProfileTest");
        //open hoversPage
        HoversPage hoversPage = new HoversPage(driver,log);
        hoversPage.openPage();
        //open User 2 profile
        hoversPage.openUserProfile(2);
        //verify correct user profile opened
        Assert.assertTrue(hoversPage.getCurrentUrl().contains("/users/2"),
                "Url of opened page is not expected User 2 page url");
    }
}
