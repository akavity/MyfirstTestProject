import org.example.driver.DriverManager;
import org.example.pages.RegistrationBntuFormPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BntuTest extends BaseTest {
    protected WebDriver driver;
    private RegistrationBntuFormPage registrationBntuFormPage;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        registrationBntuFormPage   = new RegistrationBntuFormPage(driver);
    }

    @Test
    public void checkRegistrationFromDataBntu() {
        registrationBntuFormPage.enterLogin("BasilAka");
        registrationBntuFormPage.enterPassword("12345");
        registrationBntuFormPage.clickStudentAccount();
        registrationBntuFormPage.clickButtonGo();
    }
}
