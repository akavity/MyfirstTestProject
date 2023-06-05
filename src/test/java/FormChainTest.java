import org.example.driver.DriverManager;
import org.example.models.UserData;
import org.example.pages.RegistrationFormChainPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FormChainTest extends BaseTest {
    protected WebDriver driver;
    private RegistrationFormChainPage registrationFormPage;

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][]{
                {new UserData("Alex")},
                {new UserData("Basil")}
        };
    }

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        registrationFormPage = new RegistrationFormChainPage(driver);
    }

    @Test(dataProvider = "data-provider")
    public void checkRegistrationFormDataChain(UserData userData) {

        String userDataText = registrationFormPage
                .enterFirstName(userData.getName())
                .enterLastName("Akavity")
                .clickMaleRadioButton()
                .enterMobileNumber("7529545499")
                .clickSubmitButton()
                .getDataText();

        Assert.assertTrue(userDataText.contains(userData.getName()));
    }
}
