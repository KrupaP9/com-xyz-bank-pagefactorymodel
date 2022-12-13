package com.xyz.bank.pages;

import com.aventstack.extentreports.Status;
import com.xyz.bank.customlisteners.CustomListeners;
import com.xyz.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class BankManagerLoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    WebElement addCustomerButton;
    @CacheLookup
    @FindBy(xpath = "//button[@ng-class='btnClass2']")
    WebElement openAccountButton;
    public void clickOnAddCustomerButton() {
        Reporter.log("Clicking on add customer Button " + addCustomerButton.toString());
        clickOnElement(addCustomerButton);
        CustomListeners.test.log(Status.PASS,"Click on add customer Button");
    }
    public void clickOpenAccountButton() {
        Reporter.log("Clicking on open account Button " + openAccountButton.toString());
        clickOnElement(openAccountButton);
        CustomListeners.test.log(Status.PASS,"Click on open account Button");
    }
}
