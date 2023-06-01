package org.example.pages;

import org.example.utils.Waiters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationFormPage {
    private WebDriver driver;

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

    public RegistrationFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void enterFirstName(String firstName) {
//        Waiters.waitForVisibility(firstNameField);
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void clickButton() {
        maleRadioButton.click();
    }

    public void enterMobilePhoneNumber(String mobilePhoneNumber) {
        mobilePhoneNumberField.sendKeys(mobilePhoneNumber);
    }

    public void clickDropDown(String state) {
        dropDown.sendKeys(state);
        dropDown.sendKeys(Keys.RETURN);
    }

    public void uploadPictureInput(String path) {
        picture.sendKeys(path);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
