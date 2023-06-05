package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationFormChainPage extends BasePage {

    protected WebDriver driver;

    @FindBy(id = "firstName")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@placeholder=\"Last Name\"]")
    private WebElement lastNameField;

    @FindBy(xpath = "//label[@for=\"gender-radio-1\"]")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//input[@placeholder=\"Mobile Number\"]")
    private WebElement mobilePhoneNumberField;

    @FindBy(id = "react-select-3-input")
    private WebElement dropDown;

    @FindBy(id = "uploadPicture")
    private WebElement picture;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(xpath = ".//tr[1]/td[1]/following-sibling::td")
    private WebElement userDataText;


    public RegistrationFormChainPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationFormChainPage enterFirstName(String name) {
        firstNameField.sendKeys(name);
        return this;
    }

    public RegistrationFormChainPage enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public RegistrationFormChainPage clickMaleRadioButton() {
        maleRadioButton.click();
        return this;
    }

    public RegistrationFormChainPage enterMobileNumber(String number) {
        mobilePhoneNumberField.sendKeys(number);
        return this;
    }

    public RegistrationFormChainPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public String getDataText() {
        return userDataText.getText();
    }
}
