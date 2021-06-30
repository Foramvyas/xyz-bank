package com.bank.pages;

import com.bank.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomersPage extends Utility {


    private static final Logger log = LogManager.getLogger(CustomersPage.class.getName());

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchCustomerButton;
    @FindBy(xpath = "//button[contains(text(),'Delete')]")
    WebElement deleteButton;

    public void searchCustomerByName(String name){
        Reporter.log("Searching customer name: " +name+ "to search customer field :" +searchCustomerButton.toString() + "<br>");
        sendTextToElement(searchCustomerButton, name);
        log.info("Searching customer name: " +name+ "to search customer field :" +searchCustomerButton.toString());
    }

     public void deleteCustomerDetails(){
        Reporter.log("Deleting Customer Name :" +deleteButton.toString() + "<br>");
        clickOnElement(deleteButton);
        log.info("Deleting Customer Name :" +deleteButton.toString());
    }

}
