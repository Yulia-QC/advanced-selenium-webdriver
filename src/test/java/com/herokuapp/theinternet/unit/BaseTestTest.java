package com.herokuapp.theinternet.unit;

import com.herokuapp.theinternet.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTestTest extends BaseTest {

    @Test
    public void testSetUp() {
        // Assert that the driver and log objects are initialized properly in setUp method
        Assert.assertNotNull(driver);
        Assert.assertNotNull(log);

    }


}

