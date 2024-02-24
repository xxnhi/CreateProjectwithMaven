package anhtester.pages;

import anhtester.common.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignInPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;

    private By emailInput = By.xpath("//input[@id='iusername']");
    private By passwordInput = By.xpath("//input[@id='ipassword']");
    private By loginSubmitBtn = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/button[1]");

    public SignInPage(WebDriver driver){
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

    public void signIn(String email, String password){
        validateHelper.waitForPageLoaded();
        Assert.assertTrue(validateHelper.verifyElementText(loginSubmitBtn,"Login"),"Khong phai trang Login");
        validateHelper.setText(emailInput, email);
        validateHelper.setText(passwordInput, password);
        validateHelper.clickElement(loginSubmitBtn);
        Assert.assertTrue(validateHelper.verifyPageTitle("HRM | Anh Tester Demo | Log in"),"Tittle hien tai khong dung");

    }
}
