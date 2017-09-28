package com.company.pageobjects;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageObjectBase {
    public static String url ="http://executeautomation.com/demosite/Login.html";
    public WebDriver driver;

    @FindBy(xpath = "/html/body/form/p[1]/input")
    public WebElement txtUserName;

    @FindBy(xpath = "/html/body/form/p[2]/input")
    public  WebElement txtPassword;

    @FindBy(name = "Login")
    public  WebElement btnLogin;

    @FindBy(id = "Initial")
    public  WebElement title;

    public static LoginPage visitPage(WebDriver driver) {
        LoginPage page = new LoginPage(driver);
        page.visitPage();
        return page;
    }

    public LoginPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public void Login(String username, String password){
        waitForElement(txtPassword, driver);
        txtUserName.clear();
        txtUserName.sendKeys(username);
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void ClickLogin(){
        waitForElement(btnLogin, driver);
        btnLogin.submit();
    }

    public void isDisplayed() {
        waitForPageLoad(driver);
        waitForElement(title, driver);
        Assert.assertEquals("Its not displayed", title.isDisplayed(), true);
    }
}
