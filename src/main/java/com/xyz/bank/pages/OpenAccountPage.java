package com.xyz.bank.pages;

import com.aventstack.extentreports.Status;
import com.xyz.bank.customlisteners.CustomListeners;
import com.xyz.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {
    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement customerNameDropDown;
    @CacheLookup
    @FindBy(id = "currency")
    WebElement currencyDropDown;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processButton;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement clickHomePageButton;

    public void selectCustomerNameByVisibleText(String registeredID){
        Reporter.log("selecting " + registeredID.toString()+"from "+customerNameDropDown.toString());
        selectByVisibleTextFromDropDown(customerNameDropDown,registeredID);
        CustomListeners.test.log(Status.PASS,"select customer name"+registeredID);
    }
    public void selectCurrencyFromDropDown(String currencyOption){
        Reporter.log("selecting " + currencyOption.toString()+"from "+currencyDropDown.toString());
        selectByVisibleTextFromDropDown(currencyDropDown,currencyOption);
        CustomListeners.test.log(Status.PASS,"select currency"+currencyOption);
    }
    public void clickOnProcessButton(){
        Reporter.log("Clicking on process Button " + processButton.toString());
        clickOnElement(processButton);
        CustomListeners.test.log(Status.PASS,"Click on processButton");
    }
    public String getTextFromAccountCreatedSuccessfullyPopup(){
        Reporter.log("Getting account created successfully message " + getTextFromAlert());
        CustomListeners.test.log(Status.PASS,"Get account created successfully message");
        return getTextFromAlert();
    }
    public void clickOKOnPopup(){
        Reporter.log("Clicking on ok on popup ");
        acceptAlert();
        CustomListeners.test.log(Status.PASS,"Click on ok on popup");
    }
    public void clickHomePage(){
        Reporter.log("Clicking on Home Page Button " + clickHomePageButton.toString());
        clickOnElement(clickHomePageButton);
        CustomListeners.test.log(Status.PASS,"Click on home Button");
    }
}
