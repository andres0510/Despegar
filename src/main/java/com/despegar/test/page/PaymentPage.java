package com.despegar.test.page;

import com.despegar.test.action.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    public PaymentPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- LOCATORS --------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    @FindBy(xpath = "//*[@id='chk-total-price']//*[contains(@class,'amount')]")
    private WebElement labelPrice;

    @FindBy(xpath = "(//*[contains(@class,'dm-title-container')]//*[contains(@class,'eva-3-h3')])[1]")
    private WebElement labelCities;

    @FindBy(xpath = "//*[text()=' IDA ']/parent::*[contains(@class,'dm-date')]/div[2]")
    private WebElement labelDepartureDate;

    @FindBy(xpath = "//*[text()=' VUELTA ']/parent::*[contains(@class,'dm-date')]/div[2]")
    private WebElement labelReturnDate;

    //----------------------------------------------------------------------------------------------------------------->
    //---------- ACTIONS ---------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public String getFlightPrice() {
        return DriverManager.getText(labelPrice).trim();
    }

    public String getCities() {
        return DriverManager.getText(labelCities).trim();
    }

    public String getDepartureDate() {
        return DriverManager.getText(labelDepartureDate).trim();
    }

    public String getReturnDate() {
        return DriverManager.getText(labelReturnDate).trim();
    }

}
