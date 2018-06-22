package com.academy.automation.practice.ddt.manager.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

    @FindBy(css="#header > div.nav > div > div > nav > div:nth-child(1) > a")
    private WebElement userLink;

    @FindBy(css="#header > div.nav > div > div > nav > div:nth-child(2) > a")
    private WebElement logoutLink;

    @FindBy(css="#header > div.nav > div > div > nav > div:nth-child(1) > a > span")
    private WebElement userNameLink;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getLoginCapture() {
        return userLink.getText().trim();
    }

    public HomePage clickLogout() {
        logoutLink.click();
        return new HomePage(driver);
    }

    public String getUserNameCapture() {
        return userNameLink.getText().trim();
    }

}
