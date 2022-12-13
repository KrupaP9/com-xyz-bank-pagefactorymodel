package com.xyz.bank.testsuite;

import com.xyz.bank.customlisteners.CustomListeners;
import com.xyz.bank.pages.*;
import com.xyz.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {
    HomePage homePage;
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomersPage customersPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customersPage = new CustomersPage();
        customerLoginPage = new CustomerLoginPage();
        accountPage = new AccountPage();
    }

    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        //click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginButton();
        //	click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomerButton();
        //	enter FirstName
        addCustomerPage.sendFirstName("Prime");
        //	enter LastName
        addCustomerPage.sendLastName("Tester");
        //	enter PostCode
        addCustomerPage.sendPostCode("E89899");
        //	click On "Add Customer" Button
        addCustomerPage.clickAddCustomerButton();
        //	popup display
        //	verify message "Customer added successfully"
        Assert.assertTrue(addCustomerPage.getTextFromCustomerAddedPopUp().contains("Customer added successfully"), "customer added successfully message not displayed");
        //	click on "ok" button on popup.
        addCustomerPage.clickOKOnAlert();
    }

    @Test(groups = {"smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        //click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginButton();
        //	click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomerButton();
        //	enter FirstName
        addCustomerPage.sendFirstName("Prime");
        //	enter LastName
        addCustomerPage.sendLastName("Tester");
        //	enter PostCode
        addCustomerPage.sendPostCode("E89899");
        //	click On "Add Customer" Button
        addCustomerPage.clickAddCustomerButton();
        //	popup display
        //	click on "ok" button on popup.
        addCustomerPage.clickOKOnAlert();
        Thread.sleep(1000);
        addCustomerPage.clickOnOpenAccountButton();
        //click On "Bank Manager Login" Tab
        //addCustomerPage.getbaseUrl();
        Thread.sleep(1000);
        //homePage.clickOnBankManagerLoginButton();
        //	click On "Open Account" Tab
        //bankManagerLoginPage.clickOpenAccountButton();
        //	Search customer that created in first test
        openAccountPage.selectCustomerNameByVisibleText("Prime Tester");
        //	Select currency "Pound"
        openAccountPage.selectCurrencyFromDropDown("Pound");
        //	click on "process" button
        openAccountPage.clickOnProcessButton();
        //	popup displayed
        //	verify message "Account created successfully"
        Assert.assertTrue(openAccountPage.getTextFromAccountCreatedSuccessfullyPopup().contains("Account created successfully"), "Popup not displayed");
        //	click on "ok" button on popup.
        openAccountPage.clickOKOnPopup();
    }

    @Test (groups = "regression")
    public void customerShouldLoginAndLogoutSuceessfully() throws InterruptedException {
        Thread.sleep(1000);
        //click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginButton();
        //	click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomerButton();
        //	enter FirstName
        addCustomerPage.sendFirstName("Prime");
        //	enter LastName
        addCustomerPage.sendLastName("Tester");
        //	enter PostCode
        addCustomerPage.sendPostCode("E89899");
        //	click On "Add Customer" Button
        addCustomerPage.clickAddCustomerButton();
        //	popup display
        //	click on "ok" button on popup.
        addCustomerPage.clickOKOnAlert();
        //open account button
        addCustomerPage.clickOnOpenAccountButton();
        openAccountPage.selectCustomerNameByVisibleText("Prime Tester");
        //	Select currency "Pound"
        openAccountPage.selectCurrencyFromDropDown("Pound");
        //	click on "process" button
        openAccountPage.clickOnProcessButton();
        //	click on "ok" button on popup.
        openAccountPage.clickOKOnPopup();
        addCustomerPage.clickHomePageButton();
        //click on "Customer Login" Tab
        homePage.clickCustomerLoginButton();
        //	search customer that you created.
        customersPage.selectYourName("Prime Tester");
        //	click on "Login" Button
        customersPage.clickOnLogin();
        //	verify "Logout" Tab displayed.
        Thread.sleep(1500);
        Assert.assertEquals(accountPage.getLogoutText(), "Logout", "Logout text not displayed");
        //	click on "Logout"
        //Thread.sleep(500);
        accountPage.clickLogout();
        //	verify "Your Name" text displayed.
        Assert.assertTrue(customersPage.getYourNameText().contains("Your Name"), "Your Name not displayed");

    }

    @Test (groups = "regression")
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        Thread.sleep(1000);
        //click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginButton();
        //	click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomerButton();
        //	enter FirstName
        addCustomerPage.sendFirstName("Prime");
        //	enter LastName
        addCustomerPage.sendLastName("Tester");
        //	enter PostCode
        addCustomerPage.sendPostCode("E89899");
        //	click On "Add Customer" Button
        addCustomerPage.clickAddCustomerButton();
        //	popup display
        //	verify message "Customer added successfully"
        Assert.assertTrue(addCustomerPage.getTextFromCustomerAddedPopUp().contains("Customer added successfully"), "customer added successfully message not displayed");
        //	click on "ok" button on popup.
        addCustomerPage.clickOKOnAlert();
        Thread.sleep(1000);
        //openAccountPage.clickHomePage();
        //Thread.sleep(1000);
        //open account button
        addCustomerPage.clickOnOpenAccountButton();
        openAccountPage.selectCustomerNameByVisibleText("Prime Tester");
        //	Select currency "Pound"
        openAccountPage.selectCurrencyFromDropDown("Pound");
        //	click on "process" button
        openAccountPage.clickOnProcessButton();
        //	click on "ok" button on popup.
        openAccountPage.clickOKOnPopup();
        addCustomerPage.clickHomePageButton();
        //click on "Customer Login" Tab
        homePage.clickCustomerLoginButton();
        //	search customer that you created.
        customersPage.selectYourName("Prime Tester");
        //	click on "Login" Button
        customersPage.clickOnLogin();
        Thread.sleep(1500);
        //	click on "Deposit" Tab
        accountPage.clickOnDeposit();
        //	Enter amount 100
        accountPage.sendAmountToInputBox("100");
        //	click on "Deposit" Button
        accountPage.clickOnDepositAfterAmount();
        //	verify message "Deposit Successful"
        Assert.assertEquals(accountPage.getTextFromSuccessMessage(), "Deposit Successful", "Deposit successful message not displayed");
    }

    @Test(groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully()throws InterruptedException {
        Thread.sleep(1000);
        //click On "Bank Manager Login" Tab
        homePage.clickOnBankManagerLoginButton();
        //	click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomerButton();
        //	enter FirstName
        addCustomerPage.sendFirstName("Prime");
        //	enter LastName
        addCustomerPage.sendLastName("Tester");
        //	enter PostCode
        addCustomerPage.sendPostCode("E89899");
        //	click On "Add Customer" Button
        addCustomerPage.clickAddCustomerButton();
        //	popup display
        //	verify message "Customer added successfully"
        Assert.assertTrue(addCustomerPage.getTextFromCustomerAddedPopUp().contains("Customer added successfully"), "customer added successfully message not displayed");
        //	click on "ok" button on popup.
        addCustomerPage.clickOKOnAlert();
        Thread.sleep(1000);
        //openAccountPage.clickHomePage();
        //Thread.sleep(1000);
        //open account button
        addCustomerPage.clickOnOpenAccountButton();
        openAccountPage.selectCustomerNameByVisibleText("Prime Tester");
        //	Select currency "Pound"
        openAccountPage.selectCurrencyFromDropDown("Pound");
        //	click on "process" button
        openAccountPage.clickOnProcessButton();
        //	click on "ok" button on popup.
        openAccountPage.clickOKOnPopup();
        addCustomerPage.clickHomePageButton();
        //click on "Customer Login" Tab
        homePage.clickCustomerLoginButton();
        //	search customer that you created.
        customersPage.selectYourName("Prime Tester");
        //	click on "Login" Button
        customersPage.clickOnLogin();
        Thread.sleep(1500);
        //	click on "Deposit" Tab
        accountPage.clickOnDeposit();
        //	Enter amount 100
        accountPage.sendAmountToInputBox("100");
        //	click on "Deposit" Button
        accountPage.clickOnDepositAfterAmount();
        Thread.sleep(1500);
        accountPage.clickOnWithdrawalButton();
        //	Enter amount 50
        Thread.sleep(1500);
        accountPage.sendAmountToInputBoxWithdrawal("50");
        //	click on "Withdraw" Button
        accountPage.clickOnWithdrawButton();
        //	verify message "Transaction Successful"
        Assert.assertEquals(accountPage.getTextFromSuccessMessageTransaction(), "Transaction successful", "Transaction Successful message not displayed");
    }
}
