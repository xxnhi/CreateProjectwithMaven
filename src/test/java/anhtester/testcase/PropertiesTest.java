package anhtester.testcase;

import anhtester.base.BaseSetup;
import anhtester.common.PropertiesFile;
import anhtester.common.ValidateHelper;
import anhtester.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PropertiesTest {

    private WebDriver driver;
    private SignInPage signInPage;
    private ValidateHelper validateHelper;

    @BeforeClass
    public void createDriver() {
        // Gọi hàm để khởi tạo file properties
        PropertiesFile.setPropertiesFile();

        // Đọc data từ file properties với key là "browser"
        driver = new BaseSetup().setupDriver(PropertiesFile.getPropValue("browser"));
    }


    @Test
    public void signinCRM() {
        signInPage = new SignInPage(driver);
        driver.get("https://hrm.anhtester.com/erp/login");

        //Set giá trị vào file properties
        PropertiesFile.setPropValue("name", "xxnhi");

        // Đọc data từ file properties
        signInPage.signIn(PropertiesFile.getPropValue("email"), PropertiesFile.getPropValue("password"));

    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }

}


