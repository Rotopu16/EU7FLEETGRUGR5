package com.fleetgru.pages;

import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.ConfigurationReader;
import com.fleetgru.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class DashBoardPage extends BasePage{

    @FindBy(css = "#user-menu>a")
    public WebElement nameInProfile;

    @FindBy(linkText = "Logout")
    public WebElement logOutButton;

    @FindBy(css = ".fa-caret-down")
    public WebElement nameInProfileDropDown;



    public void logOut(){
        nameInProfile.click();
        logOutButton.click();
    }
    public void openNewTab(){
        BrowserUtils.waitFor(3);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("window.open()");
        Set<String> windowHandles = Driver.get().getWindowHandles();
        for (String handle : windowHandles) {
            Driver.get().switchTo().window(handle);
            if (Driver.get().getTitle().equals("New Tab")) {
                break;
            }
        }
        Driver.get().navigate().to(ConfigurationReader.get("url"));
    }



}
