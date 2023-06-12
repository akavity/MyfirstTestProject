import io.qameta.allure.Link;
import org.example.driver.DriverManager;
import org.example.models.UserData;
import org.example.step.RegistrationFormSteps;
import org.example.utils.AllureListener;
import org.example.utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class FormTest extends BaseTest {
    protected WebDriver driver;
    private RegistrationFormSteps registrationFormSteps;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        registrationFormSteps = new RegistrationFormSteps(driver);
    }

    @Link("https://demoqa.com/automation-practice-form")
    @Test(description = "Check registration form data",
            dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void checkRegistrationFormData(UserData userData) {
        registrationFormSteps.fillForm(userData);

        Assert.assertTrue(registrationFormSteps.getDataText().contains(userData.getFirstName()));
    }

    @Link("https://demoqa.com/automation-practice-form")
    @Test(description = "Check registration form separate data",
            dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void checkRegistrationFormSeparateData(UserData userData) {
        registrationFormSteps.enterFirstName(userData.getFirstName());
        registrationFormSteps.enterLastName(userData.getLastName());
        registrationFormSteps.clickButton();
        registrationFormSteps.enterMobilePhoneNumber(userData.getPhoneNumber());
        registrationFormSteps.clickDropDown(userData.getState());
        registrationFormSteps.uploadPictureInput(userData.getPath());
        registrationFormSteps.clickSubmitButton();

        Assert.assertTrue(registrationFormSteps.getDataText().contains(userData.getFirstName()));
    }
}
