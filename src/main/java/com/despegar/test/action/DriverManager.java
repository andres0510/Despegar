package com.despegar.test.action;

import com.despegar.test.helpers.Report;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager(){}

    //----------------------------------------------------------------------------------------------------------------->
    //---------- DRIVER INITIATION ------------------------------------------------------------------------------------>
    //----------------------------------------------------------------------------------------------------------------->

    public static void initDriverManager(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        Wait.initWait(driver);
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- GETTER ----------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public static WebDriver getDriver(){
        return driver;
    }

    //----------------------------------------------------------------------------------------------------------------->
    //---------- ACTIONS ---------------------------------------------------------------------------------------------->
    //----------------------------------------------------------------------------------------------------------------->

    public static void open(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public static void finish() {
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            Report.reportFail(String.format("Error closing browser: %s", e.getMessage()));
        }
    }

    public static void click(WebElement element) {
        Wait.forElementClickable(element);
        element.click();
    }

    public static String getText(WebElement element) {
        Wait.forElementVisible(element);
        return element.getText();
    }

    public static void sendText(WebElement element, String text) {
        Wait.forElementVisible(element);
        element.sendKeys(text);
    }

    public static void clearText(WebElement element) {
        Wait.forElementVisible(element);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
    }

    public static void selectOption(WebElement element, String option) {
        Wait.forElementVisible(element);
        Select select = new Select(element);
        select.selectByVisibleText(option);
    }

    public static boolean isVisible(WebElement element) {
        try {
            Wait.forElementDisplayed(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
