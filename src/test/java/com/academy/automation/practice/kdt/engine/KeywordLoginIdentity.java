package com.academy.automation.practice.kdt.engine;

import com.academy.automation.practice.ddt.manager.page.LoginPage;
import org.openqa.selenium.WebDriver;

public class KeywordLoginIdentity {
    private WebDriver driver;

    public KeywordLoginIdentity(WebDriver driver) {
        this.driver = driver;
    }

    public void doAction(String action, String object, String value) {
        switch (action) {
            case "INPUT":
                input(object, value);
                break;

            case "CLICK":
                click(object, value);
                break;
        }
    }

    private void input(String object, String value) {
        switch (object) {
            case "login":
                new LoginPage(driver).inputLogin(value);
                break;

            case "password":
                new LoginPage(driver).inputPassword(value);
                break;
        }
    }

    private void click(String object, String value) {
        switch (object) {
            case "signInButton":
                new LoginPage(driver).clickSignIn(false);
                break;
        }
    }
}
