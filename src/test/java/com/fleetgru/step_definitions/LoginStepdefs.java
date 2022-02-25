package com.fleetgru.step_definitions;

import com.fleetgru.pages.DashBoardPage;
import com.fleetgru.pages.LoginPage;
import com.fleetgru.utilities.BrowserUtils;
import com.fleetgru.utilities.ConfigurationReader;
import com.fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginStepdefs {

    LoginPage loginPage = new LoginPage();

    @Given("User enters valid {string} credentials")
    public void userEntersValidCredentials(String userType) {
        loginPage.loginAsUserType(userType);
    }

    @And("User clicks on Login button")
    public void userClicksOnLoginButton() {
        BrowserUtils.waitForClickablility(loginPage.submit, 10);
        loginPage.submit.click();
    }

    @Then("User should land on {string} page")
    public void userShouldLandOnPage(String subPageTitle) {
        System.out.println("expectedTitle = " + subPageTitle);
        BrowserUtils.waitFor(2);
        Assert.assertTrue(loginPage.subPageTitle.getText().contains(subPageTitle));
    }

    @Given("The user is on the Login page")
    public void theUserIsOnTheLoginPage() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();
    }

    @Given("User enters invalid or empty {string} and {string}")
    public void userEntersInvalidOrEmptyAnd(String username, String password) {
        BrowserUtils.waitFor(2);
        loginPage.login(username, password);
    }

    @Then("User should see {string}")
    public void userShouldSee(String expectedMessage) {
        if (expectedMessage.equals("Invalid user name or password.")) {
            BrowserUtils.waitForVisibility(loginPage.invalidMessage, 5);
            Assert.assertTrue(loginPage.invalidMessage.isDisplayed());

        } else {
            BrowserUtils.waitFor(2);
            String actualMessage = loginPage.userName.getAttribute("validationMessage");
            String actualMessage2 = loginPage.password.getAttribute("validationMessage");
            Assert.assertTrue(expectedMessage.equals(actualMessage) || expectedMessage.equals(actualMessage2));
        }
    }

    @When("The user clicks {string} link")
    public void theUserClicksLink(String forgotPassword) {
        BrowserUtils.waitForClickablility(loginPage.forgotPassword, 5);
        loginPage.forgotPassword.click();
    }

    @Then("User lands on the {string} page")
    public void userLandsOnThePage(String expectedTitle) {
        System.out.println("expectedTitle = " + expectedTitle);
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getTitle().contains(expectedTitle));
    }

    @Then("Remember Me link is visible")
    public void rememberMeLinkIsVisible() {
        Assert.assertTrue(loginPage.rememberMeLink.isDisplayed());
    }

    @And("Remember Me Check box is visible")
    public void rememberMeCheckBoxIsVisible() {
        BrowserUtils.waitForClickablility(loginPage.rememberMeCheckBox, 5);
        Assert.assertTrue(loginPage.rememberMeCheckBox.isEnabled());
    }

    @When("The user clicks Remember Me CheckBox")
    public void theUserClicksRememberMeCheckBox() {
        BrowserUtils.waitForClickablility(loginPage.rememberMeCheckBox, 5);
        loginPage.rememberMeCheckBox.click();
    }

    @Then("Remember Me Check Box is checked")
    public void rememberMeCheckBoxIsChecked() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(loginPage.rememberMeCheckBox2.isSelected());
    }

    @And("User clicks on Enter key of the keybord")
    public void userClicksOnEnterKeyOfTheKeybord() {
        BrowserUtils.waitFor(1);
        Actions action = new Actions(Driver.get());
        action.sendKeys(Keys.ENTER).perform();
    }

    @And("The {string}s can see their own usernames in the profile menu")
    public void theSCanSeeTheirOwnUsernamesInTheProfileMenu(String userType) {

        DashBoardPage dashBoardPage = new DashBoardPage();
        BrowserUtils.waitForVisibility(dashBoardPage.nameInProfile, 5);

        String actualName = dashBoardPage.nameInProfile.getText();
        System.out.println("actualName = " + actualName);
        Assert.assertTrue(dashBoardPage.getUserName(userType).equals(actualName));

    }

    @When("User enters password credentials")
    public void userEntersPasswordCredentials() {
        BrowserUtils.waitForClickablility(loginPage.password, 5);
        loginPage.password.sendKeys("password");
    }

    @Then("The User sees the password in bullet signs by default")
    public void theUserSeesThePasswordInBulletSignsByDefault() {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(loginPage.password.getAttribute("type").equals("password"));
    }
}
