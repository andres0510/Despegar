package com.despegar.test.page;

import com.despegar.test.action.DriverManager;
import com.despegar.test.action.Wait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {

    public CalendarPage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- LOCATORS --------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    private static final String XPATH_TABLE_MONTH = "//*[contains(@class,'sbox5-floating-tooltip-opened')]//*[@data-month='%s']";

    private static final String XPATH_OPTION_DAY = "%s//*[contains(@class,'sbox5-monthgrid-datenumber-number') and text()='%s']";

    @FindBy(xpath = "//*[contains(@class,'sbox5-floating-tooltip-opened')]//*[contains(@class,'calendar-arrow-right')]")
    private WebElement btnNextMonth;

    //----------------------------------------------------------------------------------------------------------------->
    //---------- ACTIONS ---------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public boolean searchedMonthIsVisible(String date) {
        String monthXpath = String.format(XPATH_TABLE_MONTH, date);
        return DriverManager.isVisible(monthXpath);
    }

    public void clickOptionDay(String date, String day) {
        String monthXpath = String.format(XPATH_TABLE_MONTH, date);
        String dayXpath = String.format(XPATH_OPTION_DAY, monthXpath, day);
        Wait.forElementDisplayed(dayXpath);
        DriverManager.click(dayXpath);
    }

    public void clickBtnNextMonth() {
        DriverManager.click(btnNextMonth);
    }

}
