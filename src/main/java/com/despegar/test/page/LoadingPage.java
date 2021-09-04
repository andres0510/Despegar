package com.despegar.test.page;

import com.despegar.test.action.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoadingPage {

    public LoadingPage(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- LOCATORS --------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    @FindBy(xpath = "//*[contains(@class,'progress-bar-background')]")
    private WebElement loadingProgressBar;

    @FindBy(xpath = "eva-loader")
    private WebElement loadingLoop;

    //----------------------------------------------------------------------------------------------------------------->
    //---------- ACTIONS ---------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public boolean isLoadingProgressBar(){
        return DriverManager.isVisible(loadingProgressBar);
    }

    public boolean isLoadingLoop(){
        return DriverManager.isVisible(loadingProgressBar);
    }

}
