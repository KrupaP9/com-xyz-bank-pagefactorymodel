package com.xyz.bank.pages;

import com.aventstack.extentreports.Status;
import com.xyz.bank.customlisteners.CustomListeners;
import com.xyz.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomersPage extends Utility {
    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement yourNameDropDown;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement yourNameText;
    public void selectYourName(String yourNameOption) {
        Reporter.log("Select your name " + yourNameOption + " from " + yourNameDropDown.toString());
        selectByVisibleTextFromDropDown(yourNameDropDown, yourNameOption);
        CustomListeners.test.log(Status.PASS,"select your name " + yourNameOption);
    }
    public void clickOnLogin() {
        Reporter.log("Clicking on login Button " + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"Click on login Button");
    }
    public String getYourNameText(){
        Reporter.log("Getting your name message " + yourNameText.toString());
        CustomListeners.test.log(Status.PASS,"Get your name text");
        return getTextFromElement(yourNameText);
    }
}
