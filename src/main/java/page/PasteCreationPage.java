package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasteCreationPage extends BaseClassPage {

    @FindBy(xpath = "//div[@class='source bash']//ol")
    private WebElement createdPasteForBashText;

    @FindBy(xpath = "//div[@class='info-top']")
    private WebElement createdPasteTitle;

    public PasteCreationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getBashText() {
        waitForElementLocated(driver, convertToBy(createdPasteForBashText));
        return createdPasteForBashText.getText().trim();
    }
    public String getTitleText() {
        waitForElementLocated(driver, convertToBy(createdPasteTitle));
        return createdPasteTitle.getText().trim();
    }
}
