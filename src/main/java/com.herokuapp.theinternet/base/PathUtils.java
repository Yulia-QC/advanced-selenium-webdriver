package com.herokuapp.theinternet.base;

import java.io.File;

public class PathUtils {
    private PathUtils() {
    }
    public static String getFullPath(String shortPath) {
        var filePath = new File(PathUtils.class.getResource(shortPath).getPath()).getAbsolutePath();
        return filePath;
    }
}
