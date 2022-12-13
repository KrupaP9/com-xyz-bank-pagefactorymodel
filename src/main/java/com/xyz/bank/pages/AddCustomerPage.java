package com.xyz.bank.pages;

import com.aventstack.extentreports.Status;
import com.xyz.bank.customlisteners.CustomListeners;
import com.xyz.bank.propertyreader.PropertyReader;
import com.xyz.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomerButton;
    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    WebElement openAccountButton;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement clickHomePage;
    String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");
    public void sendFirstName(String inputFirstName){
        Reporter.log("Enter first name " + inputFirstName + " to first name field " + firstName.toString());
        sendTextToElement(firstName,inputFirstName);
        CustomListeners.test.log(Status.PASS,"Enter first name " + inputFirstName);
    }
    public void sendLastName(String inputLastName){
        Reporter.log("Enter last name " + inputLastName + " to last name field " + lastName.toString());
        sendTextToElement(lastName, inputLastName);
        CustomListeners.test.log(Status.PASS,"Enter last name " + inputLastName);
    }
    public void sendPostCode(String inputPostCode){
        Reporter.log("Enter postcode " + inputPostCode + " to postcode field " + postCode.toString());
        sendTextToElement(postCode,inputPostCode);
        CustomListeners.test.log(Status.PASS,"Enter postcode " + inputPostCode);
    }
    public void clickAddCustomerButton(){
        Reporter.log("Clicking on add customer Button " + addCustomerButton.toString());
        clickOnElement(addCustomerButton);
        CustomListeners.test.log(Status.PASS,"Click on add customer Button");
    }
    public String getTextFromCustomerAddedPopUp(){
        Reporter.log("Getting customer added popup message " + getTextFromAlert());
        CustomListeners.test.log(Status.PASS,"Get Text From customer added popup message");
        return getTextFromAlert();
    }
    public void clickOKOnAlert(){
        Reporter.log("Clicking on add customer Button ");
        acceptAlert();
        CustomListeners.test.log(Status.PASS,"Click on add customer Button");
    }
    public void clickOnOpenAccountButton(){
        Reporter.log("Clicking on open account Button " + openAccountButton.toString());
        clickOnElement(openAccountButton);
        CustomListeners.test.log(Status.PASS,"Click on open account Button");
    }
    public void getbaseUrl() {
        Reporter.log("Reloading baseUrl");
        driver.get(baseUrl);
        CustomListeners.test.log(Status.PASS,"Reload BaseUrl");
    }

    public void clickHomePageButton(){
        Reporter.log("Clicking on Home Page Button " + clickHomePage.toString());
        clickOnElement(clickHomePage);
        CustomListeners.test.log(Status.PASS,"Click on home Button");
    }

}
