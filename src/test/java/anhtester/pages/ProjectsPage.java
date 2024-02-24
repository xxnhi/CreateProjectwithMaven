package anhtester.pages;

import anhtester.common.ValidateHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.util.List;

public class ProjectsPage {
    private WebDriver driver;

    private ValidateHelper validateHelper;
    private By projectMenu = By.xpath("//span[contains(text(),'Projects')]");

    private By projectSearchInput = By.xpath("//body/div[2]/div[1]/div[4]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/label[1]/input[1]");





    public ProjectsPage(WebDriver driver){
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }

    public void goToProjectPage(){
        validateHelper.clickElement(projectMenu);
    }

    public void enterSearchValue(String value){
        validateHelper.setText(projectSearchInput,value);
    }

    public void checkSearchTableByColumn(int column, String value) {
        //Xác định số dòng của table sau khi search
        List<WebElement> row = driver.findElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        System.out.println("Số dòng tìm thấy: " + rowTotal);
        //Duyệt từng dòng
        for (int i = 1; i <= rowTotal; i++) {
            WebElement elementCheck = driver.findElement(By.xpath("//table//tbody/tr[" + i + "]/td[" + column + "]"));

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", elementCheck);

            System.out.print(value + " - ");
            System.out.println(elementCheck.getText());
            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }

    }


}
