package com.academy.automation.practice.kdt.engine;

import org.openqa.selenium.WebDriver;

public class KeywordIdentity {

    private WebDriver driver;
    private KeywordHomeIdentity homeAction;
    private KeywordLoginIdentity loginAction;
    private KeywordMyAccountIdentity myAccountAction;

    public KeywordIdentity(WebDriver driver) {
        this.driver = driver;
        homeAction = new KeywordHomeIdentity(driver);
        loginAction = new KeywordLoginIdentity(driver);
        myAccountAction = new KeywordMyAccountIdentity(driver);
    }
    // TODO
    public void doAction(String page, String action, String object, String value) {
        switch (page) {
            case "Home":
                homeAction.doAction(action, object, value);
                break;

            case "Login":
                loginAction.doAction(action, object, value);
                break;

            case "MyAccount":
                myAccountAction.doAction(action, object, value);
                break;

            case "":
                doAction(action, object, value);
                break;
        }
    }

    private void doAction(String action, String object, String value) {
        switch (action) {
            case "GOTOURL":
                driver.get(value);
                break;
        }
    }
}
