package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.WeakHashMap;

public class OpenAccountPage extends Utility {

    private static final Logger log = LogManager.getLogger(OpenAccountPage.class.getName());

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerName;

    @FindBy(id = "currency")
    WebElement currencyTab;
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;


    public void selectExistingCustomerName(){
        Reporter.log("Select name of existing customer from drop down " +customerName.toString() + "<br>");
        log.info("Select name of existing customer from drop down " +customerName.toString());
        clickOnElement(customerName);
    }

    public void selectNameFromDropDown(String customer){
        Reporter.log("Select value from dropdown" +customerName.toString() + "<br");
        log.info("Select value from dropdown" +customerName.toString());
        selectByVisibleTextFromDropDown( customerName,customer);
    }


    public void selectCurrency(String currency) {
        Reporter.log("Select currency from drop down " + currencyTab.toString() + "<br>");
        log.info("Select currency from drop down " + currencyTab.toString());
        selectByVisibleTextFromDropDown(currencyTab, currency);
    }

    public void clickOnProcessButton() {
        Reporter.log("Clicking on process Button" + processButton.toString() + "<br>");
        log.info("Clicking on process Button " + processButton.toString());
        clickOnElement(processButton);

    }

}
