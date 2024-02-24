package anhtester.testcase;

import anhtester.common.ExcelHelpers;
import anhtester.common.ValidateHelper;
import anhtester.pages.ProjectsPage;
import anhtester.pages.SignInPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.File;

public class SignInTest {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private SignInPage signInPage;

    private ProjectsPage projectPage;

    private ExcelHelpers excel;
//    private By loginBtn = By.id("btn-login");

//    private By selectDropdown = By.id("dropdown");


    @Test (priority = 1)
    public void signIn() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //==========quan trong============
        validateHelper = new ValidateHelper(driver);
        //==========quan trong============
        signInPage = new SignInPage(driver);

        excel = new ExcelHelpers();
        //setup duong dan cua file excel
        excel.setExcelFile("src/test/resources/book1.xlsx","Sheet1");

        driver.get("https://hrm.anhtester.com/erp/login");

        validateHelper.waitForPageLoaded();
        //doc data tu file excel, dong va cot bat dau tu 0
        signInPage.signIn(excel.getCellData("email",1),excel.getCellData("password",1));

//        //ghi data vao file excel
//        excel.setCellData("anhtester.com",2,0);

//
//        //ghi nhieu data
//        for(int i = 0; i < 6; i++){
//            excel.setCellData("XN" + i, i,3);
//        }
    }

    @Test (priority = 2)
    public void projectTest() throws Exception {

        projectPage = new ProjectsPage(driver);
        projectPage.goToProjectPage();
        projectPage.enterSearchValue("abc");
        projectPage.checkSearchTableByColumn(3,"a");
    }

    //Tao lien ket giua cac page trong POM
//    public DashboardPage signIn(String emailValue, String passwordValue) {
//        validateUIHelpers.waitForPageLoaded();
//        Assert.assertTrue(validateUIHelpers.verifyElementText(signinBtn, "Sign in"), "Không phải trang Sign In");
//        validateUIHelpers.setText(emailInput, emailValue);
//        validateUIHelpers.setText(passwordInput, passwordValue);
//        validateUIHelpers.clickElement(signinBtn);
//
//        return new DashboardPage(this.driver);
//    }
}
