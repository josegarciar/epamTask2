package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;
import page.PasteCreationPage;

import static org.junit.Assert.assertEquals;

public class CreateNewPasteTest {
    private WebDriver driver;

    String pasteCodeText= "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    String pasteNameText= "how to gain dominance among developers";


    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void createNewPaste() {
        //Step 1 Open https://pastebin.com/ or a similar service in any browser.
        HomePage homePage = new HomePage(driver);
        homePage.openPage();
        //Step 2 Create 'New Paste' with the following attributes:


        //enter paste code
        homePage.enterPasteCode(pasteCodeText);
        //close banner
        //homePage.clickCloseBanner();
        //select Syntax highlighting
        homePage.selectSyntaxHighlightingOption(0);
        //select Syntax highlighting
        homePage.selectExpirationOption(2);
        // enter Paste Name
        homePage.enterPasteName(pasteNameText);
        // click create new paste btn
        homePage.clickCreateNewPasteBtn();

        // validate created paste in new page
        PasteCreationPage pasteCreationPage = new PasteCreationPage(driver);
        // verify bash code text
        assertEquals(pasteCodeText, pasteCreationPage.getBashText());
        // verify paste name text
        assertEquals(pasteNameText, pasteCreationPage.getTitleText());

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}