package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLogin;

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLogin;

   // @FindBy(xpath = "//button[contains(text(),'Home')]")
    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homeButton;

    public void clickOnCustomerLoginLink(){

        Reporter.log("Clicking on Customer Login link " + customerLogin.toString() + "<br>");
        clickOnElement(customerLogin);
        log.info("Clicking on Customer Login link" + customerLogin.toString());
    }

    public void clickOnBakManagerLoginLink(){

        Reporter.log("Clicking on Bank manager Login link " + bankManagerLogin.toString() + "<br>");
        clickOnElement(bankManagerLogin);
        log.info("Clicking on bank manager Login link" + bankManagerLogin.toString());
    }

    public void clickOnHomeButtonLink(){

        Reporter.log("Clicking on Customer Login link " + homeButton.toString() + "<br>");
        clickOnElement(homeButton);
        log.info("Clicking on home button link" + homeButton.toString());
    }


    }






