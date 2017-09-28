package com.company.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommentTextPage extends PageObjectBase {

    @FindBy(linkText = "i am a link")
    private WebElement theActiveLink;

    @FindBy(id = "your_comments")
    private WebElement yourCommentsSpan;

    @FindBy(id = "comments")
    private WebElement commentsTextAreaInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public WebDriver driver;
    public static String url = "https://saucelabs-sample-test-frameworks.github.io/training-test-page";

    public static CommentTextPage visitPage(WebDriver driver) {
        CommentTextPage page = new CommentTextPage(driver);
        page.visitPage();
        return page;
    }

    public CommentTextPage(WebDriver driver) {
        super();
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }


    public void submitComment(String text) {
        this.commentsTextAreaInput.sendKeys(text);
        this.submitButton.click();

        // Race condition for time to populate yourCommentsSpan
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        wait.until(ExpectedConditions.textToBePresentInElement(yourCommentsSpan, text));
    }

    public String getSubmittedCommentText() {
        return this.yourCommentsSpan.getText();
    }

}
