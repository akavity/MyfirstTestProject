package org.example.step;

import lombok.extern.log4j.Log4j2;
import org.example.models.UserData;
import org.example.pages.RegistrationFormPage;
import org.example.utils.Waiters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RegistrationFormSteps {

    private RegistrationFormPage registrationFormPage;
    public RegistrationFormSteps(WebDriver driver) {
        registrationFormPage = new RegistrationFormPage(driver);
    }

    public void enterFirstName(String firstName) {
        Waiters.waitForVisibility(registrationFormPage.getFirstNameField());
        log.info("Enter first name");
        registrationFormPage.getFirstNameField().sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        log.info("Enter last name");
        registrationFormPage.getLastNameField().sendKeys(lastName);
    }

    public void clickButton() {
        log.info("Click male Radio Button");
        registrationFormPage.getMaleRadioButton().click();
    }

    public void enterMobilePhoneNumber(String mobilePhoneNumber) {
        log.info("Enter mobile Phone number");
        registrationFormPage.getMobilePhoneNumberField().sendKeys(mobilePhoneNumber);
    }

    public void clickDropDown(String state) {
        log.info("Click drop down");
        registrationFormPage.getDropDown().sendKeys(state);
        registrationFormPage.getDropDown().sendKeys(Keys.RETURN);
    }

    public void uploadPictureInput(String path) {
        log.info("Upload picture input");
        registrationFormPage.getPicture().sendKeys(path);
    }

    public void clickSubmitButton() {
        log.info("Click submit button");
        registrationFormPage.getSubmitButton().click();
    }

    public String getDataText() {
        log.info("Get user data text");
        return registrationFormPage.getUserDataText().getText();
    }

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
//        log.info("Click drop down");
//        registrationFormPage.getDropDown().sendKeys(state);
//        registrationFormPage.getDropDown().sendKeys(Keys.RETURN);
//        log.info("Upload picture input");
//        registrationFormPage.getPicture().sendKeys(path);
        log.info("Click submit button");
        registrationFormPage.getSubmitButton().click();
    }
}
