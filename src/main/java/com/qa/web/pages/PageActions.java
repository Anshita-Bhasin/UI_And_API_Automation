package com.qa.web.pages;

import com.qa.web.base.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.qa.web.utils.TestUtil.clickOn;

public class PageActions extends TestBase {

    @FindBy(xpath = "//a[contains(text(),'Droppable')]")
    private WebElement droppable;

    @FindBy(xpath = "//*[@id='draggable']")
    private WebElement dragElement;

    @FindBy(xpath = "//*[@id='droppable']")
    private WebElement dropElement;

    @FindBy(xpath = "//a[contains(text(),'Selectable')]")
    private WebElement selectable;

    @FindBy(xpath = "//li[contains(text(),'Item 1')]")
    private WebElement Item1;

    @FindBy(xpath = "//li[contains(text(),'Item 3')]")
    private WebElement Item3;

    @FindBy(xpath = "//li[contains(text(),'Item 7')]")
    private WebElement Item7;

    @FindBy(xpath = "//a[contains(text(),'Controlgroup')]")
    private WebElement controlGroup;


    @FindBy(xpath = "//span[@id=\"car-type-button\"]")
    private WebElement rentalCar1;

    @FindBy(xpath = "//span[@id=\"ui-id-8-button\"]")
    private WebElement rentalCar2;

    @FindBy(xpath = "//div[contains(text(),\"SUV\") and @id=\"ui-id-4\"]")
    private WebElement SUV;

    @FindBy(xpath = "//div[contains(text(),\"Truck\") and @id=\"ui-id-14\"]")
    private WebElement Truck;


    @FindBy(xpath = "//span[@class=\"ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank\"]//parent::label[@for=\"transmission-automatic\"]")
    private WebElement suvAutomatic;

    @FindBy(xpath = "//label[@for=\"insurance\"]")
    private WebElement suvInsurance;

    @FindBy(xpath = "//label[@for=\"insurance-v\"]")
    private WebElement truckInsurance;

    @FindBy(xpath = "//input[@id=\"horizontal-spinner\"]")
    private WebElement numberOfSUV;


    @FindBy(xpath = "//input[@id='vertical-spinner']")
    private WebElement numberOfTrucks;

    @FindBy(xpath = "//span[@class=\"ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank\"]//parent::label[@for=\"transmission-standard-v\"]")
    private WebElement truckStandard;

    @FindBy(xpath = "//button[@id=\"book\"]")
    private WebElement bookNow;


    public PageActions() {
        PageFactory.initElements(driver, this);
    }


    public void selectDroppableInteraction() {
        clickOn(driver,droppable);

    }

    public void selectSelectableInteraction() {
        clickOn(driver,selectable);
    }


    public void performDragAndDrop() {

        driver.switchTo().frame(0);
        Actions action = new Actions(driver);
        action.clickAndHold(dragElement)
                .moveToElement(dropElement)
                .release()
                .build().perform();

    }

    public void selectOptions() {
        driver.switchTo().frame(0);
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL);
        Item1.click();
        action.build().perform();
        action.keyUp(Keys.CONTROL);
        Item3.click();
        Item7.click();


    }

    public void selectWidget() {
        clickOn(driver,controlGroup);
        driver.switchTo().frame(0);
    }

    public void chooseSUV() {
        rentalCar1.click();
        SUV.click();


    }

    public void chooseTruck() {
        rentalCar2.click();
        Truck.click();


    }

    public void SUVDetails() {

        suvAutomatic.click();
        suvInsurance.click();
        numberOfSUV.sendKeys("2");

    }

    public void TruckDetails() {

        truckStandard.click();
        truckInsurance.click();
        numberOfTrucks.sendKeys("1");

    }

    public void BookNow() {
        bookNow.click();

    }


}
