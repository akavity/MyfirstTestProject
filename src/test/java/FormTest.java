import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class FormTest {
    @Test
    public void checkRegistrationFormData() {

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "G:\\Installation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.sendKeys("Basil");

        WebElement lastNameField = driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]"));
        lastNameField.sendKeys("Akavity");

        WebElement maleRadioButton = driver.findElement(By.xpath("//label[@for=\"gender-radio-1\"]"));
        maleRadioButton.click();

        WebElement mobilePhoneNumberField = driver.findElement(By.xpath("//input[@placeholder=\"Mobile Number\"]"));
        mobilePhoneNumberField.sendKeys("75295454");

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        Assert.assertTrue(firstNameField.getText().contains("Basil"));

        driver.quit();
    }
}
