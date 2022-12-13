package com.xyz.bank.pages;

import com.aventstack.extentreports.Status;
import com.xyz.bank.customlisteners.CustomListeners;
import com.xyz.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutButtonText;
    @CacheLookup
    @FindBy(xpath = "//button[@class='btn logout']")
    WebElement logoutButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='borderM box padT20 ng-scope']//button[2]")
    WebElement depositButton;

    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    WebElement withdrawalButton;

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement amountInput;

    @CacheLookup
    @FindBy(xpath = "//body/div[3]/div[1]/div[2]/div[1]/div[4]/div[1]/form[1]/div[1]/input[1]")
    WebElement amountInputWithdrawal;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Deposit']")
    WebElement depositAfterAmount;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement successMessage;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessMessage;

    @CacheLookup
    @FindBy(xpath = "//button[text()='Withdraw']")
    WebElement withdrawButton;
    public void clickOnDeposit(){
        Reporter.log("Clicking on deposit Button " + depositButton.toString());
        mouseHoverToElementAndClick(depositButton);
        CustomListeners.test.log(Status.PASS,"Click on deposit Button");
    }
    public void clickOnWithdrawalButton(){
        Reporter.log("Clicking on withdrawal Button " + withdrawalButton.toString());
        clickOnElement(withdrawalButton);
        CustomListeners.test.log(Status.PASS,"Click on withdrawal Button");
    }
    public void sendAmountToInputBox(String userInputAmount){
        Reporter.log("Enter amount " + userInputAmount + " to amount field " + amountInput.toString());
        sendTextToElement(amountInput,userInputAmount);
        CustomListeners.test.log(Status.PASS,"Enter amount " + userInputAmount);
    }
    public void sendAmountToInputBoxWithdrawal(String userInputAmount){
        Reporter.log("Enter amount " + userInputAmount + " to amount field " + amountInputWithdrawal.toString());
        sendTextToElement(amountInputWithdrawal,userInputAmount);
        CustomListeners.test.log(Status.PASS,"Enter amount " + userInputAmount);
    }
    public void clickOnDepositAfterAmount(){
        Reporter.log("Clicking on deposit Button " + depositAfterAmount.toString());
        clickOnElement(depositAfterAmount);
        CustomListeners.test.log(Status.PASS,"Click on deposit Button");
    }
    public String getTextFromSuccessMessage(){
        Reporter.log("Getting success message " + depositSuccessMessage.toString());
        CustomListeners.test.log(Status.PASS,"Get Text From success message");
        return getTextFromElement(depositSuccessMessage);
    }
    public String getTextFromSuccessMessageTransaction(){
        Reporter.log("Getting success message " + successMessage.toString());
        CustomListeners.test.log(Status.PASS,"Get Text From success message");
        return getTextFromElement(successMessage);
    }
    public void clickOnWithdrawButton(){
        Reporter.log("Clicking on withdraw Button " + withdrawButton.toString());
        mouseHoverToElementAndClick(withdrawButton);
        CustomListeners.test.log(Status.PASS,"Click on withdraw Button");
    }
    public String getLogoutText(){
        return getTextFromElement(logoutButton);
    }
    public void clickLogout(){
        clickOnElement(logoutButton);
    }
}
