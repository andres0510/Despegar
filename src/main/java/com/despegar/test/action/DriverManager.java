package com.despegar.test.action;

import com.despegar.test.helpers.Report;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager(){}

    //----------------------------------------------------------------------------------------------------------------->
    //---------- DRIVER INITIATION ------------------------------------------------------------------------------------>
    //----------------------------------------------------------------------------------------------------------------->

    public static void init(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        Wait.init(driver);
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

    public static void click(String xpath) {
        Wait.forElementDisplayed(xpath);
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void clickJS(String xpath) {
        Wait.forElementClickable(xpath);
        String script = String.format("document.evaluate(\"%s\", document, null, 9, null).singleNodeValue.click()", xpath);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(script);
    }

    public static String getText(WebElement element) {
        Wait.forElementVisible(element);
        return element.getText();
    }

    public static void sendText(WebElement element, String text) {
        Wait.forElementVisible(element);
        element.click();
        element.sendKeys(text);
    }

    public static void clearText(WebElement element) {
        Wait.forElementVisible(element);
        element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
    }

    public static boolean isVisible(WebElement element) {
        try {
            Wait.forElementDisplayed(element);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static boolean isVisible(String xpath) {
        try {
            Wait.forElementDisplayed(xpath);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
