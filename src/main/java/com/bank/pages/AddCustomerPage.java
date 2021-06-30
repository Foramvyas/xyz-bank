package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {

    private static final Logger log = LogManager.getLogger(AddCustomerPage.class.getName());

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomerButton;


    public void enterFirstName(String firstname) {
        Reporter.log("Entering first name : " + firstname + " to first name field : " + firstName.toString() + "<br>");
        sendTextToElement(firstName, firstname);
        log.info("Entering first name : " + firstname + " to first name field : " + firstName.toString());
    }

    public void enterLastName(String lastname) {
        Reporter.log("Entering last name : " + lastname + " to last name field : " + lastName.toString() + "<br>");
        sendTextToElement(lastName, lastname);
        log.info("Entering last name : " + lastname + " to last name field : " + lastName.toString());
    }

    public void enterPostCode(String postcode) {
        Reporter.log("Entering post code : " + postcode + " to post code field : " + postCode.toString() + "<br>");
        sendTextToElement(postCode, postcode);
        log.info("Entering post code: " + postcode + " to post code field : " + postCode.toString());
    }

    public void clickOnAddToCustomerButton() {
        Reporter.log("Clicking on Add to Customer Button" + addCustomerButton.toString() + "<br>");
        log.info("Clicking on Add to Customer Button " + addCustomerButton.toString());
        clickOnElement(addCustomerButton);

    }

    public String verifyPopUpMessage() {
        Alert alertDialogue = driver.switchTo().alert();
        return alertDialogue.getText();
    }

    public void clickOnOkPopUpButton() {
        Alert alertDialogue = driver.switchTo().alert();
        alertDialogue.accept();
    }

}









