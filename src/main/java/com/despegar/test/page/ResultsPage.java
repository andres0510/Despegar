package com.despegar.test.page;

import com.despegar.test.action.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

    public ResultsPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- LOCATORS --------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    @FindBy(xpath = "(//airlines-matrix-airline/ul)[1]//*[@class='airline-description']")
    private WebElement boxFirstFlight;

    @FindBy(xpath = "(//em[text()='Precio final ']/parent::*//*[contains(@class,'amount price-amount')])[1]")
    private WebElement labelFirstFlightPrice;

    @FindBy(xpath = "(//em[text()='Seleccionar']/parent::*/parent::a)[1]")
    private WebElement btnSelectFlight;

    @FindBy(xpath = "//*[@id='upselling-popup-position']//h3")
    private WebElement popupBuyBaggageSpace;

    @FindBy(xpath = "//*[contains(@class,'amount price-amount') and text()='0']")
    private WebElement optionStandardBaggage;

    @FindBy(xpath = "//*[@id='upselling-popup-position']//button")
    private WebElement btnContinueBaggage;

    //----------------------------------------------------------------------------------------------------------------->
    //---------- ACTIONS ---------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public String getFlightPrice(){
        return DriverManager.getText(labelFirstFlightPrice).trim();
    }

    public void clickBoxFirstFlight(){
        DriverManager.click(boxFirstFlight);
    }

    public void clickBtnSelectFirstFlight(){
        DriverManager.click(btnSelectFlight);
    }

    public boolean baggagePopupIsVisible(){
        return DriverManager.isVisible(popupBuyBaggageSpace);
    }

    public void clickStandardBaggage(){
        DriverManager.click(optionStandardBaggage);
    }

    public void clickBtnContinueBaggage(){
        DriverManager.click(btnContinueBaggage);
    }

}
