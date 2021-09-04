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

    @FindBy(xpath = "(//airlines-matrix-airline/ul)[1]//*[contains(@class,'amount price-amount')]")
    private WebElement labelFirstFlightPrice;

    @FindBy(xpath = "(//em[text()='Seleccionar']/parent::*/parent::a)[1]")
    private WebElement btnSelectFlight;

    //----------------------------------------------------------------------------------------------------------------->
    //---------- ACTIONS ---------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public String getFlightPrice(){
        return DriverManager.getText(labelFirstFlightPrice).trim();
    }

    public void clickBoxFirstFlight(){
        DriverManager.click(boxFirstFlight);
    }

    public void clickSelectFirstFlight(){
        DriverManager.click(btnSelectFlight);
    }

}
