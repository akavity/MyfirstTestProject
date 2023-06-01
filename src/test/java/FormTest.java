import org.example.driver.DriverManager;
import org.example.pages.RegistrationFormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {
    protected WebDriver driver;
    private RegistrationFormPage registrationFormPage;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        registrationFormPage = new RegistrationFormPage(driver);
    }

    @Test
    public void checkRegistrationFormData() {
        registrationFormPage.enterFirstName("Basil");
        registrationFormPage.enterLastName("Akavity");
        registrationFormPage.clickButton();
        registrationFormPage.enterMobilePhoneNumber("7529545499");
        registrationFormPage.clickDropDown("NCR");
        registrationFormPage.uploadPictureInput("G:\\home\\akavity\\dev\\course-qa-automation-engineer\\" +
                "MyFirstTestProject\\src\\main\\resources\\2.jpg");
        registrationFormPage.clickSubmitButton();

        WebElement userDataText = driver.findElement(By.xpath(".//tr[1]/td[1]/following-sibling::td"));

        Assert.assertTrue(userDataText.getText().contains("Basil Akavity"));
    }
}
