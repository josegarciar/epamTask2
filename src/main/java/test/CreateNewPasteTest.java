package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePage;

import static org.junit.Assert.assertEquals;

public class CreateNewPasteTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void createNewPaste()  {
        HomePage validatePasteCreation = new HomePage()
                .openPage(driver)
                .clickElement(driver, HomePage.BANNER_CLOSE)
                .sendData(driver, HomePage.NEW_PASTE_TEXT_INPUT, "git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force\n")

                .selectData(driver, HomePage.SYNTAX_HIGHLIGHTING1, HomePage.SYNTAX_HIGHLIGHTING2, 0)
                .selectData(driver, HomePage.PASTE_EXPIRATION1, HomePage.PASTE_EXPIRATION2, 2)
                .sendData(driver, HomePage.PASTE_NAME_TITLE, "how to gain dominance among developers")
                .clickElement(driver, HomePage.CREATE_NEW_PASTE_BTN);

        // Asserts
        assertEquals("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force", validatePasteCreation.getText(driver, HomePage.CREATED_PASTE_TEXT));
        assertEquals("how to gain dominance among developers", validatePasteCreation.getText(driver, HomePage.TITLE_TEXT));

    }

    @After
    public void tearDown() {
        //if (driver != null) {
            driver.quit();
       // }
    }
}
