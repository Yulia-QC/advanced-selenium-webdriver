package com.herokuapp.theinternet.draganddroppagetests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTests extends TestUtilities {
    @Test
    public void dragAToBTests() {
        log.info("Starting dragAToBTest");
        //openDragAndDrop page
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver,log);
        dragAndDropPage.openPage();
        //Drag box A and drop it to box B
        dragAndDropPage.dragAToB();
        //Verify correct headers in correct boxes
        String columnAText = dragAndDropPage.getColumnAText();
        Assert.assertTrue(columnAText.equals("B"), "Column A header should be B, but it is: " + columnAText);

        String columnBText = dragAndDropPage.getColumnBText();
        Assert.assertTrue(columnBText.equals("A"),"Column A header should be B, but it is: " + columnBText);
    }
}
