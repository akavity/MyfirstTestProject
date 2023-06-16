package org.example.step;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.example.models.UserData;
import org.example.pages.RegistrationFormPage;
import org.example.utils.Waiters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RegistrationFormSteps {

    private final RegistrationFormPage registrationFormPage;

    public RegistrationFormSteps(WebDriver driver) {
        registrationFormPage = new RegistrationFormPage(driver);
    }

    @Step("Enter first name")
    public void enterFirstName(String firstName) {
        Waiters.waitForVisibility(registrationFormPage.getFirstNameField());
        log.info("Enter first name");
        registrationFormPage.getFirstNameField().sendKeys(firstName);
    }

    @Step("Enter last name")
    public void enterLastName(String lastName) {
        log.info("Enter last name");
        registrationFormPage.getLastNameField().sendKeys(lastName);
    }

    @Step("Click male Radio Button")
    public void clickButton() {
        log.info("Click male Radio Button");
        registrationFormPage.getMaleRadioButton().click();
    }

    @Step("Enter mobile Phone number")
    public void enterMobilePhoneNumber(String mobilePhoneNumber) {
        log.info("Enter mobile Phone number");
        registrationFormPage.getMobilePhoneNumberField().sendKeys(mobilePhoneNumber);
    }

    @Step("Click drop down")
    public void clickDropDown(String state) {
        log.info("Click drop down");
        registrationFormPage.getDropDown().sendKeys(state);
        registrationFormPage.getDropDown().sendKeys(Keys.RETURN);
    }

    @Step("Upload picture input")
    public void uploadPictureInput(String path) {
        log.info("Upload picture input");
        registrationFormPage.getPicture().sendKeys(path);
    }

    @Step("Click submit button")
    public void clickSubmitButton() {
        log.info("Click submit button");
        registrationFormPage.getSubmitButton().click();
    }

    @Step("Get user data text")
    public String getDataText() {
        log.info("Get user data text");
        return registrationFormPage.getUserDataText().getText();
    }

    @Step("Fill user form")
    public void fillForm(UserData userData) {
        Waiters.waitForVisibility(registrationFormPage.getFirstNameField());
        log.info("Enter first name");
        registrationFormPage.getFirstNameField().sendKeys(userData.getFirstName());
        log.info("Enter last name");
        registrationFormPage.getLastNameField().sendKeys(userData.getLastName());
        log.info("Click male Radio Button");
        registrationFormPage.getMaleRadioButton().click();
        log.info("Enter mobile Phone number");
        registrationFormPage.getMobilePhoneNumberField().sendKeys(userData.getPhoneNumber());
        log.info("Click drop down");
        registrationFormPage.getDropDown().sendKeys(userData.getState());
        registrationFormPage.getDropDown().sendKeys(Keys.RETURN);
        log.info("Upload picture input");
        registrationFormPage.getPicture().sendKeys(userData.getPath());
        log.info("Click submit button");
        registrationFormPage.getSubmitButton().click();
    }
}
