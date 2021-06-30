package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.TestBase;

import org.apache.poi.ss.formula.functions.T;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankTest extends TestBase {
    // Test data that is being used for the testing purpose

    String firstname = "Virat";
    String lastname  = "Jani";
    String customer  = firstname + " " + lastname;
    String postcode  = "nw9 9hn";
    String currency  = "Pound";
    String depositAmount = "100";
    String withdrawlAmount = "50";

    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void SetUpPage() {

        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customerLoginPage = new CustomerLoginPage();
        accountPage = new AccountPage();
    }

    @Test(groups = {"sanity","smoke","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        homePage.clickOnBakManagerLoginLink();
        bankManagerLoginPage.clickOnAddToCustomerTab();
        addCustomerPage.enterFirstName(firstname);
        addCustomerPage.enterLastName(lastname);
        addCustomerPage.enterPostCode(postcode);
        addCustomerPage.clickOnAddToCustomerButton();
        String actualMessage = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage.contains("Customer added successfully"));
        addCustomerPage.clickOnOkPopUpButton();
        homePage.clickOnHomeButtonLink();
    }

    @Test(groups = {"smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        homePage.clickOnBakManagerLoginLink();
        bankManagerLoginPage.clickOnAddToCustomerTab();
        addCustomerPage.enterFirstName(firstname);
        addCustomerPage.enterLastName(lastname);
        addCustomerPage.enterPostCode(postcode);
        addCustomerPage.clickOnAddToCustomerButton();
        String actualMessage = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage.contains("Customer added successfully"));
        addCustomerPage.clickOnOkPopUpButton();

        bankManagerLoginPage.clickOnOpenAccountTab();
        Thread.sleep(500);
        openAccountPage.selectNameFromDropDown(customer);
        Thread.sleep(500);
        openAccountPage.selectCurrency(currency);
        Thread.sleep(1000);
        openAccountPage.clickOnProcessButton();
        String actualMessage1 = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage1.contains("Account created successfully"));
        addCustomerPage.clickOnOkPopUpButton();
    }

    @Test(groups = "regression")
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        homePage.clickOnBakManagerLoginLink();
        bankManagerLoginPage.clickOnAddToCustomerTab();
        addCustomerPage.enterFirstName(firstname);
        addCustomerPage.enterLastName(lastname);
        addCustomerPage.enterPostCode(postcode);
        addCustomerPage.clickOnAddToCustomerButton();
        String actualMessage = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage.contains("Customer added successfully"));
        addCustomerPage.clickOnOkPopUpButton();

        bankManagerLoginPage.clickOnOpenAccountTab();
        Thread.sleep(500);
        openAccountPage.selectExistingCustomerName();
        openAccountPage.selectNameFromDropDown(customer);
        Thread.sleep(500);
        openAccountPage.selectCurrency(currency);
        Thread.sleep(1000);
        openAccountPage.clickOnProcessButton();
        String actualMessage1 = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage1.contains("Account created successfully"));
        addCustomerPage.clickOnOkPopUpButton();

        homePage.clickOnHomeButtonLink();
        homePage.clickOnCustomerLoginLink();
        Thread.sleep(500);
        openAccountPage.selectNameFromDropDown(customer);
        customerLoginPage.clickOnLoginLink();
        Thread.sleep(500);
        customerLoginPage.verifyLogoutButtonDisplayed();
        String expectedText = "Logout";
        String actualText = customerLoginPage.verifyLogOutText();
        Assert.assertEquals(actualText, expectedText);
        //Thread.sleep(500);
        customerLoginPage.clickOnLogOutButton();
        customerLoginPage.veriftTextYourNameDisplayed("Your Name");
        String expectedMessage2 = "Your Name :";
        String actualMessage2 = customerLoginPage.verifyYourNameText();
        Assert.assertEquals(actualMessage2, expectedMessage2);

    }

    @Test(groups = "regression")
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {


        homePage.clickOnBakManagerLoginLink();
        bankManagerLoginPage.clickOnAddToCustomerTab();
        addCustomerPage.enterFirstName(firstname);
        addCustomerPage.enterLastName(lastname);
        addCustomerPage.enterPostCode(postcode);
        addCustomerPage.clickOnAddToCustomerButton();
        String actualMessage = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage.contains("Customer added successfully"));
        addCustomerPage.clickOnOkPopUpButton();

        bankManagerLoginPage.clickOnOpenAccountTab();
        Thread.sleep(500);
        openAccountPage.selectExistingCustomerName();
        openAccountPage.selectNameFromDropDown(customer);
        Thread.sleep(500);
        openAccountPage.selectCurrency(currency);
        Thread.sleep(1000);
        openAccountPage.clickOnProcessButton();
        String actualMessage1 = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage1.contains("Account created successfully"));
        addCustomerPage.clickOnOkPopUpButton();


        homePage.clickOnHomeButtonLink();
        homePage.clickOnCustomerLoginLink();
        openAccountPage.selectNameFromDropDown(customer);
        customerLoginPage.clickOnLoginLink();
        accountPage.clickOnDepositButton();
        accountPage.enterAmountToDeposit(depositAmount);
        accountPage.clickDepositTab();

        String expectedMessage3 = "Deposit Successful";
        String actualMessage3 = accountPage.getTextDepositSuccessfulMessage();
        Assert.assertEquals(actualMessage3, expectedMessage3);
        homePage.clickOnHomeButtonLink();
    }

    @Test(groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        homePage.clickOnBakManagerLoginLink();
        bankManagerLoginPage.clickOnAddToCustomerTab();
        addCustomerPage.enterFirstName(firstname);
        addCustomerPage.enterLastName(lastname);
        addCustomerPage.enterPostCode(postcode);
        addCustomerPage.clickOnAddToCustomerButton();
        String actualMessage = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage.contains("Customer added successfully"));
        addCustomerPage.clickOnOkPopUpButton();

        bankManagerLoginPage.clickOnOpenAccountTab();
        Thread.sleep(500);
        openAccountPage.selectExistingCustomerName();
        openAccountPage.selectNameFromDropDown(customer);
        Thread.sleep(500);
        openAccountPage.selectCurrency(currency);
        Thread.sleep(1000);
        openAccountPage.clickOnProcessButton();
        String actualMessage1 = addCustomerPage.verifyPopUpMessage();
        Assert.assertTrue(actualMessage1.contains("Account created successfully"));
        addCustomerPage.clickOnOkPopUpButton();


        homePage.clickOnHomeButtonLink();
        homePage.clickOnCustomerLoginLink();
        openAccountPage.selectNameFromDropDown(customer);
        customerLoginPage.clickOnLoginLink();
        accountPage.clickOnDepositButton();
        accountPage.enterAmountToDeposit(depositAmount);
        accountPage.clickDepositTab();
        Thread.sleep(500);
        String expectedMessage3 = "Deposit Successful";
        String actualMessage3 = accountPage.getTextDepositSuccessfulMessage();
        Assert.assertEquals(actualMessage3, expectedMessage3);

        Thread.sleep(500);
        accountPage.clickOnWithdrawalButton();
        Thread.sleep(500);
        accountPage.enterAmountToWithdrawal(withdrawlAmount);
        Thread.sleep(500);
        accountPage.clickOnWithdrawLink();
        String expectedMessage2 = "Transaction successful";
        String actualMessage2 = accountPage.getTextTransaction();
        Assert.assertEquals(actualMessage2, expectedMessage2);


    }


}
