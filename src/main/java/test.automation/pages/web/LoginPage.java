package test.automation.pages.web;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;
import test.automation.pageobject.BasePageObject;

@Component("test.automation.pages.web.LoginPage")
public class LoginPage extends BasePageObject {
    private By title() {
        return By.xpath("//h1[contains(text(),\"Sign in\")]");
    }

    private By emailOrPhoneField() {
        return By.id("ap_email");
    }

    private By nextButton() { return By.id("continue"); }

    private By signInButton() {
        return By.id("nav-link-accountList-nav-line-1");
    }

    private By errorMessage(String message) {
        return By.xpath("//*[contains(text(), '"+message+"')]");
    }

    private By registerButton() { return By.id("createAccountSubmit"); }

    public boolean isOnPage() {
        return waitUntilPresence(title()).isDisplayed();
    }

    public void inputEmailOrPhone(String value) {
        onType(emailOrPhoneField(), value);
    }

    public void clickSignInButton() {
        onClick(signInButton());
    }

    public void clickNextButton() {
        onClick(nextButton());
    }

    public void clickRegisterButton() { onClick(registerButton()); }

    public boolean getErrorMessage(String message) {
        return waitUntilVisible(errorMessage(message)).isDisplayed();
    }
}
