package com.fleetgru.pages;

import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.ConfigurationReader;
import com.fleetgru.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
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
    public void waitUntilLoaderScreenDisappear(){
        List<WebElement>loaderMasks = Driver.get().findElements(By.cssSelector(".loader-mask.shown"));

        try {
            for (WebElement loaderMask : loaderMasks) {
                for (int i = 0; i < 10; i++) {
                    if (!loaderMask.isDisplayed()) {
                        break;
                    } else {
                        BrowserUtils.waitFor(1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
