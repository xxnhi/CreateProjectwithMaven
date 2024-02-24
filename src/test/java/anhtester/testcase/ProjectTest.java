package anhtester.testcase;

import anhtester.common.ValidateHelper;
import anhtester.pages.ProjectsPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
public class ProjectTest {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private ProjectsPage projectPage;

    @Test
    public void projectTest() throws Exception {

        //==========quan trong============
        validateHelper = new ValidateHelper(driver);
        //==========quan trong============
        projectPage = new ProjectsPage(driver);

        projectPage.goToProjectPage();
        projectPage.enterSearchValue("abc");
        projectPage.checkSearchTableByColumn(3,"a");
    }
}
