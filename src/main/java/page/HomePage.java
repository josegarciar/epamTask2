package page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends page.BaseClassPage {
    public static final String homePageUrl = "https://pastebin.com";

    @FindBy(xpath = "//*[@id='vi-smartbanner']/vli/vli")
    private WebElement banner;

    @FindBy(xpath = "//span[@id='select2-postform-format-container']")
    private WebElement syntaxHighlighting1;

    @FindBy(xpath = "(//ul[@class='select2-results__options select2-results__options--nested'])[1]//li[@role='option']")
    private WebElement syntaxHighlighting2;

    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement newPasteTextInput;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement pasteExpirationDropdown1;

    @FindBy(xpath = "//*[@id='select2-postform-expiration-results']//li[@role='option']")
    private WebElement pasteExpirationDropdown2;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement createNewPasteButton;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        openPage(homePageUrl);

    }

    public void enterPasteCode(String code) {
        sendData(driver, newPasteTextInput, code);
    }

    public void selectExpirationOption(int option) {
        selectData(driver, pasteExpirationDropdown1, pasteExpirationDropdown2, option);
    }

    public void enterPasteName(String name) {
        sendData(driver, pasteNameInput, name);
    }
    public void clickCreateNewPasteBtn(){
        clickElement(driver, createNewPasteButton);
    }

    public void clickCloseBanner(){
        clickElement(driver, banner);
    }
    public void selectSyntaxHighlightingOption(int option) {
        selectData(driver, syntaxHighlighting1, syntaxHighlighting2, option);
    }
}



