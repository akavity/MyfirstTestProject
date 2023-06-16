package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationFormPage extends BasePage {

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

    public RegistrationFormPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getMaleRadioButton() {
        return maleRadioButton;
    }

    public WebElement getMobilePhoneNumberField() {
        return mobilePhoneNumberField;
    }

    public WebElement getDropDown() {
        return dropDown;
    }

    public WebElement getPicture() {
        return picture;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getUserDataText() {
        return userDataText;
    }
}
