package com.herokuapp.theinternet.editorpagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditorTests extends TestUtilities {
    @Test
    public void defaultEditorValueTest() {
        log.info("Starting defaultEditorValueText");
        //open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        //scroll to the bottom
        welcomePage.scrollToBottom();

        //click on WYSIWYG editor link
        EditorPage editorPage = welcomePage.clickEditorLinkLocator();
        //get default editor text
        String editorText = editorPage.getEditorText();
        //Verification that new page contains expected text in source
        Assert.assertTrue(editorText.equals("Your content goes here."),
                "Editor default text is not expected. It is: " + editorText);
    }
}
