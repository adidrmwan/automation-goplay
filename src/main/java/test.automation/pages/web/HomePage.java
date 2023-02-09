package test.automation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.automation.model.UserModel;
import test.automation.pageobject.BasePageObject;
import test.automation.properties.ConfigProperties;
import test.automation.utils.FakerUtil;

import java.io.File;
import java.util.List;
import java.util.Locale;

@Component("test.automation.pages.web.HomePage")
public class HomePage extends BasePageObject {
    @Autowired
    ConfigProperties configProperties;

    private By logo() {return By.id("nav-logo-sprites"); }

    private By signInButton() {
        return By.id("nav-link-accountList-nav-line-1");
    }

    public void openPage() {
        goTo(configProperties.getWeb().getBaseUrl());
    }

    public boolean isOnHomePage() {
        return waitUntilVisible(logo()).isDisplayed();
    }

    public void clickSignInButton() {
        onClick(signInButton());
    }
}
