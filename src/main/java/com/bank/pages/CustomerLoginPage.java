package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerLoginPage extends Utility {


    private static final Logger log = LogManager.getLogger(CustomerLoginPage.class.getName());

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logOutButton;
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement verifyText;
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement yourNameText;


    public void clickOnLoginLink() {

        Reporter.log("Clicking on Login link " + loginButton.toString() + "<br>");
        clickOnElement(loginButton);
        log.info("Clicking on Customer Login link" + loginButton.toString());
    }

    public void verifyLogoutButtonDisplayed() {
        Reporter.log("Verify Logout Tab displayed " + logOutButton.toString() + "<br>");
        verifyThatElementIsDisplayed(logOutButton);
        log.info("Verify Logout Tab displayed " + logOutButton.toString());
    }

    public void clickOnLogOutButton() {
        Reporter.log("Clicking on Log out button " + logOutButton.toString() + "<br>");
        clickOnElement(logOutButton);
        log.info("Clicking on Log out button " + logOutButton.toString());
    }
    public void veriftTextYourNameDisplayed(String text) {
        Reporter.log("Verify text displayed " + verifyText.getText() + "<br>");
        verifyThatTextIsDisplayed(verifyText, text);
        log.info("Verify text displayed " + verifyText.getText());

    }
    public String verifyLogOutText(){
        Reporter.log("Verify Log out text " +logOutButton.toString() +"<br>");
        log.info("Verify Log out text " +logOutButton.toString());
        return getTextFromElement(logOutButton);
    }

  public String verifyYourNameText(){
        Reporter.log("Verify your name text "+yourNameText.toString() + "<br>");
        log.info("Verify your name text "+yourNameText.toString());
        return getTextFromElement(yourNameText);
  }

}
