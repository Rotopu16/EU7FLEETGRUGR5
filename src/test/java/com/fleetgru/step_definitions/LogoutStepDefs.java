package com.fleetgru.step_definitions;

import com.fleetgru.pages.DashBoardPage;
import com.fleetgru.pages.LoginPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.ConfigurationReader;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class LogoutStepDefs {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();

    @Given("The user is logged in as {string}")
    public void theUserIsLoggedInAs(String userType) {
        loginPage.loginAsUserType(userType);
        loginPage.submit.click();
    }

    @And("The user clicks on Profile Menu Dropdown")
    public void theUserClicksOnProfileMenuDropdown() {
        BrowserUtils.waitFor(5);
        BrowserUtils.waitForPageToLoad(20);
        BrowserUtils.waitForVisibility(dashBoardPage.nameInProfileDropDown,10);
        BrowserUtils.clickWithJS(dashBoardPage.nameInProfile);
    }

    @And("The user clicks on Logout")
    public void theUserClicksOnLogout() {
        BrowserUtils.waitForClickablility(dashBoardPage.logOutButton, 10);
        BrowserUtils.waitFor(5);
        dashBoardPage.logOutButton.click();
    }

    @And("User clicks navigate back arrow")
    public void userClicksNavigateBackArrow() {
        Driver.get().navigate().back();
    }

    @And("The user opens a new tab")
    public void theUserOpensANewTab() {
        dashBoardPage.openNewTab();
        BrowserUtils.waitFor(5);

    }

    @Then("The user checks all other opened tabs are logged out")
    public void theUserChecksAllOtherOpenedTabsAreLoggedOut() {

        BrowserUtils.waitFor(2);
        String expectedTitle = "Login";
        String actualTitle = Driver.get().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @And("The user closes the current tab")
    public void theUserClosesTheCurrentTab() {
        BrowserUtils.waitFor(3);
        Driver.get().close();
        Set<String> windowHandles = Driver.get().getWindowHandles();

        //loop through each window
        for (String handle : windowHandles) {
            //one by one change it
            Driver.get().switchTo().window(handle);
        }
    }
}
