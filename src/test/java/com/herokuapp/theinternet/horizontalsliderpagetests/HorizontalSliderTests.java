package com.herokuapp.theinternet.horizontalsliderpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.HorizontalSliderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HorizontalSliderTests extends TestUtilities {
    @Test
    public void sliderTest() {
        log.info("Starting sliderTest");
        //open HorizontalSliderPage
        HorizontalSliderPage horizontalSliderPage = new HorizontalSliderPage(driver,log);
        horizontalSliderPage.openPage();
        //set slider value
        String value = "3.5";
        horizontalSliderPage.setSliderTo(value);
        //verify slaider value
        String sliderValue = horizontalSliderPage.getSliderValue();
        Assert.assertTrue(sliderValue.equals(value), "Range is not correct");
    }
}
