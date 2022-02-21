package com.fleetgru.pages;

import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id="prependedInput")
    public WebElement userName;

    @FindBy(id="prependedInput2")
    public WebElement password;

    @FindBy(css = "#_submit")
    public WebElement submit;

    @FindBy(css = ".oro-subtitle")
    public WebElement subPageTitle;

    @FindBy(xpath = "//div[contains(text(),'Invalid user name or password.')]")
    public WebElement invalidMessage;

    @FindBy(linkText= "Forgot your password?")
    public WebElement forgotPassword;

    @FindBy(css = ".custom-checkbox__text")
    public WebElement rememberMeLink;

    @FindBy(css = ".custom-checkbox__icon")
    public WebElement rememberMeCheckBox;

    @FindBy(css = "#remember_me")
    public WebElement rememberMeCheckBox2;

    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
    }

    public void loginAsUserType(String usertype){
        String username="";
        String password="";

        switch (usertype){
            case "Driver":
                username = ConfigurationReader.get("driver_username");
                password = ConfigurationReader.get("driver_password");
                break;
            case "Store manager":
                username = ConfigurationReader.get("store_manager_username");
                password = ConfigurationReader.get("store_manager_password");
                break;
            case "Sales manager":
                username = ConfigurationReader.get("sales_manager_username");
                password = ConfigurationReader.get("sales_manager_password");
                break;
            default:
                System.out.println("Invalid user_type");
                break;
        }
        BrowserUtils.waitFor(2);
        login(username,password);
    }

}
