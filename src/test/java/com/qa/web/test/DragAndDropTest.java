package com.qa.web.test;

import com.qa.web.base.TestBase;
import com.qa.web.pages.PageActions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropTest extends TestBase {


    PageActions pageActions;

    public DragAndDropTest() {
        super();

    }


    @BeforeMethod
    public void setup() {
        Initialization();
        pageActions = new PageActions();


    }

    @Test
    public void dragAndDrop() {
        pageActions.selectDroppableInteraction();
        pageActions.performDragAndDrop();
    }


    @AfterMethod
    public void teardown() {
        driver.close();
    }

}
