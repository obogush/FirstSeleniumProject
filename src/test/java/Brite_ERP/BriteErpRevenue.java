package Brite_ERP;

import com.cybertek.utilities.BriteTestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BriteErpRevenue {
    /**
     * User story: The system should display the correct information
     * for each opportunity on the view list page and the pivot table
     * <p>
     * Acceptance Criteria: Verify that second opportunity' Expected Revenue value
     * on the pivot board should be the same as Expected
     * Revenue column value on the list board.
     * user1: eventscrmmanager36@info.com
     * user2: eventscrmmanager37@info.com"
     * eventscrmmanager
     */

    static String userNameLocator = "//input[@name='login']";
    //xpath for the storemanagerPassword box //input[@name='storemanagerPassword']
    static String passwordLocator = "//input[@id='password']";
    static String loginButtonLocator = "//button[@type='submit']";
    //static String CrmButton= "//span[@class='oe_menu_text'][contains(text(),'CRM')]";
    BriteLogin login = new BriteLogin();
    Paths path = new Paths();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);

    WebDriver driver;
    @BeforeMethod
    public void setup(){

        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://54.148.96.210/web?#action=120&active_id=channel_inbox");

        driver.findElement(By.xpath(userNameLocator)).sendKeys("Lunch_InvoicingManager3@info.com");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("LD686gfX24", Keys.ENTER);
    }


    @Test
    public void ListView() throws IOException {
        BriteLogin.login();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='o_thread_title']")));
        Assert.assertEquals(driver.getTitle(), "#Inbox - Odoo");
        driver.findElement(By.xpath(path.CrmButton)).click();
        driver.findElement(By.xpath(path.pipelineButton)).click(); //problem here
        driver.findElement(By.cssSelector(path.listButton)).click();
        String listMoney = driver.findElement(By.cssSelector(path.listNewTotals)).getText();
        driver.findElement(By.cssSelector(path.pivotButton)).click();
        String pivotMoney = driver.findElement(By.cssSelector(path.pivotNewTotals)).getText();
        Assert.assertEquals(listMoney, pivotMoney);
    }
}