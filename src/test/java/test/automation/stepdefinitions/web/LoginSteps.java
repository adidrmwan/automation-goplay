package test.automation.stepdefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import test.automation.pages.web.HomePage;
import test.automation.pages.web.LoginPage;
import test.automation.properties.UserProperties;

public class LoginSteps {

    @Autowired
    HomePage homePage;
    @Autowired
    LoginPage loginPage;
    @Autowired
    UserProperties userProperties;

    @Given("user open amazon homepage")
    public void userOpenKMSHomepage() {
        homePage.openPage();
        Assert.assertTrue(homePage.isOnHomePage());
    }

    @And("user on login page")
    public void userOnLoginPage() {
        homePage.clickSignInButton();
        Assert.assertTrue(loginPage.isOnPage());
    }

    @And("user click next button on login page")
    public void userClickLoginButtonOnLoginPage() {
        loginPage.clickNextButton();
    }

    @When("user input {string} email")
    public void userInputEmail(String value) {
        String email = userProperties.getUser(value).getEmail();
        loginPage.inputEmailOrPhone(email);
    }

    @When("user input {string} phone number")
    public void userInputPhoneNumber(String value) {
        String phone = userProperties.getUser(value).getPhone();
        loginPage.inputEmailOrPhone(phone);
    }

    @Then("user see error message {string} on login page")
    public void userSeeErrorMessageMessageOnLoginPage(String value) {
        Assert.assertTrue(loginPage.getErrorMessage(value));
    }
}
