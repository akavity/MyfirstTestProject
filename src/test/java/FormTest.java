import org.example.driver.DriverManager;
import org.example.models.UserData;
import org.example.step.RegistrationFormSteps;
import org.example.utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FormTest extends BaseTest {
    protected WebDriver driver;
    private RegistrationFormSteps registrationFormSteps;

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        registrationFormSteps = new RegistrationFormSteps(driver);
    }

    @Test(dataProvider = "userData", dataProviderClass = JsonReader.class)
    public void checkRegistrationFormData(UserData userData) {
//        registrationFormSteps.enterFirstName(name);
//        registrationFormSteps.enterLastName("Akavity");
//        registrationFormSteps.clickButton();
//        registrationFormSteps.enterMobilePhoneNumber("7529545499");
//        registrationFormSteps.clickDropDown("NCR");
//        registrationFormSteps.uploadPictureInput("G:\\home\\akavity\\dev\\course-qa-automation-engineer\\" +
//                "MyFirstTestProject\\src\\main\\resources\\2.jpg");
//        registrationFormSteps.clickSubmitButton();

        registrationFormSteps.fillForm(userData);
        Assert.assertTrue(registrationFormSteps.getDataText().contains(userData.getFirstName()));
    }
}
