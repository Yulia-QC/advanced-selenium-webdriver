package com.herokuapp.theinternet.unit;

import com.herokuapp.theinternet.base.PathUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PathUtilsTest {
    @Test
    public void getFullPathTest(){
        String filePath = PathUtils.getFullPath("/files/index.html");
        filePath = filePath.replace("\\","/");
        System.out.println(filePath);
        Assert.assertTrue(filePath.endsWith("/files/index.html"));
    }
}
