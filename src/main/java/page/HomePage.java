package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    // Element locators
    public static final String HOME_PAGE_URL = "https://pastebin.com";
    public static final String BANNER_CLOSE = "//*[@id='vi-smartbanner']/vli/vli";
    public static final String NEW_PASTE_TEXT_INPUT = "//textarea[@id='postform-text']";
    public static final String SYNTAX_HIGHLIGHTING1 = "//span[@id='select2-postform-format-container']";
    public static final String SYNTAX_HIGHLIGHTING2 = "(//ul[@class='select2-results__options select2-results__options--nested'])[1]//li[@role='option']";
    public static final String PASTE_EXPIRATION1 = "//span[@id='select2-postform-expiration-container']";
    public static final String PASTE_EXPIRATION2 = "//*[@id='select2-postform-expiration-results']//li[@role='option']";
    public static final String PASTE_NAME_TITLE = "//input[@id='postform-name']";
    public static final String CREATE_NEW_PASTE_BTN = "//button[@class='btn -big']";
    public static final String CREATED_PASTE_TEXT = "//div[@class='source bash']//ol";
    public static final String TITLE_TEXT = "//div[@class='info-top']";



    public HomePage openPage(WebDriver driver) {
        driver.get(HOME_PAGE_URL);
        driver.manage().window().maximize();
        waitForElementLocated(driver, By.xpath(NEW_PASTE_TEXT_INPUT));
        return this;
    }

    public HomePage sendData(WebDriver driver, String locator, String data) {
        waitForElementLocated(driver, By.xpath(locator));
        WebElement inputField = driver.findElement(By.xpath(locator));
        inputField.click();
        inputField.clear();
        inputField.sendKeys(data);
        return this;
    }

    public HomePage selectData(WebDriver driver, String locator1, String locator2, int option) {
        waitForElementLocated(driver, By.xpath(locator1));
        driver.findElement(By.xpath(locator1)).click();
        waitForElementLocated(driver, By.xpath(locator2));
        List<WebElement> listOfElements = driver.findElements(By.xpath(locator2));
        listOfElements.get(option).click();
        return this;
    }

    public HomePage clickElement(WebDriver driver, String locator) {
        waitForElementLocated(driver, By.xpath(locator));
        driver.findElement(By.xpath(locator)).click();
        return this;
    }

    public String getText(WebDriver driver, String locator) {
        waitForElementLocated(driver, By.xpath(locator));
        String text = driver.findElement(By.xpath(locator)).getText();
        return text.trim();
    }

    private static WebElement waitForElementLocated(WebDriver driver, By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
