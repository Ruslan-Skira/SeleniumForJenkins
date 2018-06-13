package com.academy.test.automation.practice.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

    @FindBy(css="#header > div.nav > div > div > nav > div:nth-child(1) > a")
    private WebElement userLink;

    @FindBy(css="#header > div.nav > div > div > nav > div:nth-child(2) > a")
    private WebElement logoutLink;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getLoginCapture() {
        return userLink.getText().trim();
    }

    public HomePage logout() {
        logoutLink.click();
        return new HomePage(driver);
    }
}
