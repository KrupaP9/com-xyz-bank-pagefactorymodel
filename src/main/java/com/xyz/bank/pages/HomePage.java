package com.xyz.bank.pages;

import com.aventstack.extentreports.Status;
import com.xyz.bank.customlisteners.CustomListeners;
import com.xyz.bank.propertyreader.PropertyReader;
import com.xyz.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {
    String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLogin;

    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='customer()']")
    WebElement customerLoginButton;

    public void clickOnBankManagerLoginButton() {
        Reporter.log("Clicking on bank manager login Button " + bankManagerLogin.toString());
        clickOnElement(bankManagerLogin);
        CustomListeners.test.log(Status.PASS,"Click on bank manager login Button");
    }

    public void clickCustomerLoginButton() {
        Reporter.log("Clicking on customer login Button " + customerLoginButton.toString());
        clickOnElement(customerLoginButton);
        CustomListeners.test.log(Status.PASS,"Click on customer login Button");
    }

    public void getbaseUrl() {
        Reporter.log("Reloading baseUrl");
        driver.get(baseUrl);
        CustomListeners.test.log(Status.PASS,"Reload BaseUrl");
    }

}
