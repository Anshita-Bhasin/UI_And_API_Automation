package com.qa.web.utils;

import com.qa.web.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil extends TestBase {

    public static long Page_Load_Timeout=500;
     public static long IMPLICITLY_WAIT=500;

    public static long EXPLICITILY_WAIT =30;



    public static void clickOn(WebDriver driver, WebElement webElement)
    {
        new WebDriverWait(driver, EXPLICITILY_WAIT).until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();

    }



}
