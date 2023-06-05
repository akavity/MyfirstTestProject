import org.example.driver.DriverManager;
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
        return new Object[][]{{"Alex"}, {"Basil"}};
    }

    @BeforeClass
    public void preparationForTest() {
        driver = DriverManager.getDriver();
        registrationFormPage = new RegistrationFormChainPage(driver);
    }

    @Test(dataProvider = "data-provider")
    public void checkRegistrationFormDataChain(String name) {

        String userDataText = registrationFormPage
                .enterFirstName(name).enterLastName("Akavity")
                .clickMaleRadioButton()
                .enterMobileNumber("7529545499")
                .clickSubmitButton()
                .getDataText();

        Assert.assertTrue(userDataText.contains(name));
    }
}
