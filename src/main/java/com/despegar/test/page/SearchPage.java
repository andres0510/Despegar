package com.despegar.test.page;

import com.despegar.test.action.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    public SearchPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- LOCATORS --------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    @FindBy(xpath = "//*[contains(text(),'Tramo 1')]/parent::*//*[contains(@class,'sbox-places-origin--G_Rvw')]//input")
    private WebElement inputOrigin;

    @FindBy(xpath = "//*[contains(text(),'Tramo 1')]/parent::*//*[contains(@class,'sbox-places-destination--1xd0k')]//input")
    private WebElement inputDestination;

    @FindBy(xpath = "//*[contains(text(),'Ciudades')]/parent::*/parent::*//em[1]")
    private WebElement optCity;

    @FindBy(xpath = "//*[contains(text(),'Tramo 1')]/parent::*//*[@placeholder='Ida']")
    private WebElement btnDepartureDate;

    @FindBy(xpath = "//*[contains(text(),'Tramo 1')]/parent::*//*[@placeholder='Vuelta']")
    private WebElement btnReturnDate;

    private static final String XPATH_BTN_SEARCH = "//em[text()='Buscar']/parent::*[@type='button']";

    //----------------------------------------------------------------------------------------------------------------->
    //---------- ACTIONS ---------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public void writeOriginCity(String city) {
        DriverManager.sendText(inputOrigin, city);
    }

    public void writeDestinationCity(String city) {
        DriverManager.sendText(inputDestination, city);
    }

    public void deleteDestinationCity() {
        DriverManager.clearText(inputDestination);
    }

    public boolean optionCityIsVisible(){
        return DriverManager.isVisible(optCity);
    }

    public void clickCityOption() {
        DriverManager.click(optCity);
    }

    public void clickBtnDepartureDate(){
        DriverManager.click(btnDepartureDate);
    }

    public void clickBtnReturnDate(){
        DriverManager.click(btnReturnDate);
    }

    public void clickBtnSearch(){
        DriverManager.clickJS(XPATH_BTN_SEARCH);
    }

}
